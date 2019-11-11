package org.coderandom.random_craft.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;

import java.util.HashMap;

public class TeleportBuffer implements Listener {
    private HashMap<Player, Location> buffer;
    private HashMap<Player, Long> coolDownBuffer;
    private int coolDown;

    public TeleportBuffer(int coolDown) {
        buffer = new HashMap<>();
        coolDownBuffer = new HashMap<>();
        this.coolDown = coolDown * 1000;
        Bukkit.getPluginManager().registerEvents(this, RandomCraft.getInstance());
    }

    public void clear() {
        buffer.clear();
    }

    public void addTeleport(Player player, Location location, int delay) {
        if (coolDownBuffer.containsKey(player)) {
            long currentTime = System.currentTimeMillis();
            long endTime = coolDownBuffer.get(player);

            if (currentTime < endTime) {
                long timeLeft = (endTime - currentTime) / 1000;
                player.sendMessage("§4Must wait §r" + timeLeft + "§4 seconds before trying to teleport again§6!");
                return;
            }
        }
        coolDownBuffer.put(player, System.currentTimeMillis() + coolDown);
        buffer.put(player, location);
        player.sendMessage("§2Stand still you will be teleported in §r" + delay + "§2 seconds§6!");

        new BukkitRunnable() {
            @Override
            public void run() {
                if (buffer.containsKey(player)) {
                    buffer.remove(player);
                    player.sendMessage("§2Teleporting§6!");
                    player.teleport(location);
                } else {
                    cancel();
                }
            }
        }.runTaskLater(RandomCraft.getInstance(), delay * 20);
    }

    @EventHandler
    private void onMove(PlayerMoveEvent event) {
        remove(event.getPlayer());
    }

    @EventHandler
    private void onQuit(PlayerQuitEvent event) {
        remove(event.getPlayer());
    }

    @EventHandler
    private void onTakeDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            remove((Player) event.getEntity());
        }
    }

    private void remove(Player player) {
        if (buffer.containsKey(player)) {
            buffer.remove(player);
            player.sendMessage("§4Teleport canceled§6!");
        }
    }


}
