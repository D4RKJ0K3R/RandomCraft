package org.coderandom.random_craft.utils;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

import java.util.concurrent.atomic.AtomicInteger;

public class Utils {
    public static String format(NamespacedKey key) {
        return key.toString()
                .toLowerCase()
                .replace("minecraft:", "")
                .replace("randomcraft:", "")
                .replace('_', ' ');
    }

    public static int emptySlots(Player player) {
        PlayerInventory inventory = player.getInventory();
        AtomicInteger counter = new AtomicInteger();
        if (inventory.getHelmet() == null) {
            counter.getAndDecrement();
        }
        if (inventory.getChestplate() == null) {
            counter.getAndDecrement();
        }
        if (inventory.getLeggings() == null) {
            counter.getAndDecrement();
        }
        if (inventory.getBoots() == null) {
            counter.getAndDecrement();
        }
        if (inventory.getItemInOffHand().getType().equals(Material.AIR)) {
            counter.getAndDecrement();
        }
        inventory.forEach(item -> {
            if (item == null) {
                counter.getAndIncrement();
            }
        });

        return counter.get();
    }
}
