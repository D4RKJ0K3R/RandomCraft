package org.coderandom.random_craft.custom_enchants;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class CraftListener implements Listener {
    @EventHandler
    public void event(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if (event.getClickedBlock().getType().equals(Material.GRINDSTONE)) {
                event.setCancelled(true);
                ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

                if (!item.getType().equals(Material.AIR)) {
                    event.getPlayer().getInventory().setItemInMainHand(new ItemStack(item) {
                        {
                            int level = CustomEnchants.getTotalLevels(this);
                            if (level > 0) {
                                if (CustomEnchants.hasMending(event.getPlayer())) {
                                    ExperienceOrb orb = (ExperienceOrb) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.EXPERIENCE_ORB);
                                    orb.setExperience(10);
                                }

                                setItemMeta(CustomEnchants.removeAll(this).getItemMeta());
                                event.getPlayer().giveExpLevels(level);
                                event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_GRINDSTONE_USE, 1, 1);

                            } else {
                                event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_ANVIL_HIT, 1, 1);
                            }
                            if (getType().equals(Material.ENCHANTED_BOOK)) {
                                setType(Material.BOOK);
                            }
                        }
                    });
                }
            }
        }
    }

    @EventHandler
    public void event(PrepareAnvilEvent event) {
        ItemStack too = event.getInventory().getItem(0);
        ItemStack from = event.getInventory().getItem(1);

        if (too != null && from != null && !too.getType().equals(Material.AIR) && !from.getType().equals(Material.AIR)) {
            if (too.getAmount() > 1 || from.getAmount() > 1) {
                return;
            }
            if (too.getType().equals(from.getType()) || (from.getType().equals(Material.ENCHANTED_BOOK) || too.getType().equals(Material.ENCHANTED_BOOK)) || (from.getType().equals(Material.EMERALD) || too.getType().equals(Material.EMERALD))) {
                event.setResult(new ItemStack(too) {
                    {
                        if (from.getType().equals(Material.ENCHANTED_BOOK)) {
                            ((EnchantmentStorageMeta) from.getItemMeta()).getStoredEnchants().forEach((enchantment, integer) -> setItemMeta(CustomEnchants.addEnchant(this, enchantment, integer).getItemMeta()));
                        } else {
                            from.getItemMeta().getEnchants().forEach((enchantment, integer) -> setItemMeta(CustomEnchants.addEnchant(this, enchantment, integer).getItemMeta()));
                        }
                        ItemMeta meta = getItemMeta();
                        if (meta instanceof Damageable && from.getType().equals(Material.EMERALD)) {
                            ((Damageable) meta).setDamage(0);
                        }

                        setItemMeta(meta);
                    }
                });
            }
        }
    }

    @EventHandler
    public void event(InventoryClickEvent event) {
        if (event.getInventory().getType().equals(InventoryType.ANVIL) && event.getClickedInventory() != null) {

            ItemStack too = event.getInventory().getItem(0);
            ItemStack from = event.getInventory().getItem(1);
            ItemStack result = event.getClickedInventory().getItem(2);

            if (too != null && from != null && result != null && !too.getType().equals(Material.AIR) && !from.getType().equals(Material.AIR )) {
                if (too.getType().equals(from.getType()) || from.getType().equals(Material.ENCHANTED_BOOK) || too.getType().equals(Material.ENCHANTED_BOOK) || from.getType().equals(Material.EMERALD) || too.getType().equals(Material.EMERALD)) {
                    if (event.getRawSlot() == 2) {
                        event.setCancelled(true);
                        event.getWhoClicked().getInventory().addItem(result);
                        event.getInventory().clear(0);
                        event.getInventory().clear(1);
                        event.getInventory().clear(2);
                        event.getWhoClicked().getWorld().playSound(event.getWhoClicked().getLocation(), Sound.BLOCK_ANVIL_USE, 1, 1);
                    }
                }
            }
        }
    }
}
