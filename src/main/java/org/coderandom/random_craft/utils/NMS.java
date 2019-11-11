package org.coderandom.random_craft.utils;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public interface NMS {
    ItemStack getSkull(String urlID, String itemName);
    void sendActionBar(Player player, String message);
}
