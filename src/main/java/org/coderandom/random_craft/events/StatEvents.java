package org.coderandom.random_craft.events;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.coderandom.random_craft.RandomCraft;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class StatEvents implements Listener {
    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        String blockName = event.getBlock().getType().getKey().toString().replace("minecraft:", "").replace('_', ' ');
        String message = "§6" + blockName +
                "§2 mined§1: §6" +
                (event.getPlayer().getStatistic(Statistic.MINE_BLOCK, event.getBlock().getType()) + 1);
        RandomCraft.getNms().sendActionBar(event.getPlayer(), message);
    }
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        String result = event.getRecipe().getResult().getType().getKey().toString().replace("minecraft:", "").replace('_', ' ');
        String message = "§6" + result +
                "§2 crafted§1: §6" +
                (((Player) event.getWhoClicked()).getStatistic(Statistic.CRAFT_ITEM, event.getRecipe().getResult().getType()) + 1);
        RandomCraft.getNms().sendActionBar((Player) event.getWhoClicked(), message);
    }
    @EventHandler
    public void killEntity(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();

            String entityName = entity.getType().getKey().toString().replace("minecraft:", "").replace('_', ' ');
            String message = "§6" + entityName +
                    "§2 slain§1: §6" +
                    (player.getStatistic(Statistic.KILL_ENTITY, entity.getType()) + 1);
            RandomCraft.getNms().sendActionBar(player, message);
        }
    }

    @EventHandler
    public void tradeEvent(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        if (event.getInventory().getType().equals(InventoryType.MERCHANT)) {
            if (event.getRawSlot() == 2 && !event.getCurrentItem().getType().equals(Material.AIR)){
                String message = "§2Times traded§1: §6" + (player.getStatistic(Statistic.TRADED_WITH_VILLAGER) + 1);
                RandomCraft.getNms().sendActionBar(player, message);
            }
        }
    }

    @EventHandler
    public void event(RaidTriggerEvent event) {
        Location location = event.getRaid().getLocation();
        Bukkit.getServer().broadcastMessage("§6[§4PILLAGER WARNING§6] §2Spotted a raiding party at §rX§6: §r" + location.getX() + " §rY§6: §r" + location.getY());
    }

    @EventHandler
    public void event(RaidFinishEvent event) {
        List<Player> winners = event.getWinners();
        AtomicReference<String> broadcast = new AtomicReference<String>("§6[§4PILLAGER WARNING§6] §2Raiding party defeated by §r");

        winners.forEach(player -> {
            String message = "§2Raids Won§1: §6" + (player.getStatistic(Statistic.RAID_WIN) + 1);
            RandomCraft.getNms().sendActionBar(player, message);
            broadcast.getAndSet(broadcast.get() + player.getDisplayName() + "§6, §r");
        });
        broadcast.getAndSet(broadcast.get() + " §2Victory§6!");
        Bukkit.getServer().broadcastMessage(broadcast.get());
    }

    @EventHandler
    public void event(PlayerFishEvent event) {
        if (event.getCaught() != null) {
            Player player = event.getPlayer();
            String message = "§2Fish caught§1: §6" + (player.getStatistic(Statistic.FISH_CAUGHT) + 1);
            RandomCraft.getNms().sendActionBar(player, message);
        }
    }
}
