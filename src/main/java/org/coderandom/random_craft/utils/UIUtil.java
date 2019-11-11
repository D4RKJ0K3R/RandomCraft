package org.coderandom.random_craft.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.RandomCraft;

public class UIUtil implements Listener {
    private String title;
    private int size;
    private Inventory inventory;

    public UIUtil(String title, int rows) {
        this.title = title;
        this.size = rows * 9;
        this.inventory = Bukkit.createInventory(null, this.size, title);
        RandomCraft.add(this);
    }

    public void openUI(Player player) {
        player.closeInventory();
        player.openInventory(inventory);
    }

    public void addButton(int slot, ItemStack item) {
        inventory.setItem(slot, item);
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(title)) {
            if (event.isShiftClick() || event.getRawSlot() < size) {
                event.setCancelled(true);
            }
        }
    }
}
