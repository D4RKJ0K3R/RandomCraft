package org.coderandom.random_craft.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;

public class SpongeListener implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlockPlaced().getWorld().getName().contains("nether") && event.getBlockPlaced().getType().equals(Material.WET_SPONGE)) {
            Location location = event.getBlockPlaced().getLocation();

            new BukkitRunnable() {
                @Override
                public void run() {
                    if (location.getWorld().getBlockAt(location).getType().equals(Material.WET_SPONGE)) {
                        event.getBlockPlaced().setType(Material.SPONGE);
                        event.getBlockPlaced().getWorld().playSound(event.getBlockPlaced().getLocation(), Sound.BLOCK_FIRE_EXTINGUISH, 1, 1);
                    }
                    cancel();
                }
            }.runTaskLater(RandomCraft.getInstance(), 3 * 10);
        }
    }
}
