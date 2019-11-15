package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

import java.util.ArrayList;

public class Holding_Enchantment extends CustomWrapper {
    public Holding_Enchantment() {
        super("holding", 0, 10000, new ArrayList<>(){ { add(Material.EMERALD); } });
        CustomEnchants.register(this);
    }

    @EventHandler
    public void storeEvent(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (event.hasItem() && event.getClickedBlock().getType().equals(Material.ENCHANTING_TABLE)) {
                ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

                if (item.getType().equals(Material.EMERALD) && CustomEnchants.hasEnchantment(item, this)) {

                    if (event.getPlayer().getLevel() > 0) {
                        event.setCancelled(true);

                        int xp;

                        if (CustomEnchants.getLevel(item, this) == 0) {
                            xp = event.getPlayer().getLevel();
                        } else {
                            xp = event.getPlayer().getLevel() + CustomEnchants.getLevel(item, this);
                        }

                        event.getPlayer().setLevel(0);
                        event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1, 1);

                        event.getPlayer().getInventory().setItemInMainHand(new ItemStack(item) {
                            {
                                setItemMeta(CustomEnchants.addEnchant(this, CustomEnchants.HOLDING, xp - 1).getItemMeta());
                            }
                        });
                    }
                }
            }
        }
    }

    @EventHandler
    public void unStore(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {

            if (event.hasItem() && event.getClickedBlock().getType().equals(Material.LECTERN)) {
                ItemStack item = event.getPlayer().getInventory().getItemInMainHand();

                if (item.getType().equals(Material.EMERALD) && CustomEnchants.hasEnchantment(item, this)) {
                    if (CustomEnchants.getLevel(item, this) > 0) {
                        event.setCancelled(true);
                        event.getPlayer().giveExpLevels(CustomEnchants.getTotalLevels(item));

                        if (CustomEnchants.hasMending(event.getPlayer())) {
                            ExperienceOrb orb = (ExperienceOrb) event.getPlayer().getWorld().spawnEntity(event.getPlayer().getLocation(), EntityType.EXPERIENCE_ORB);
                            orb.setExperience(10);
                        }

                        event.getPlayer().getWorld().playSound(event.getClickedBlock().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);
                        event.getPlayer().getInventory().setItemInMainHand(new ItemStack(item){
                            {
                                setItemMeta(CustomEnchants.removeAll(item).getItemMeta());
                                setItemMeta(CustomEnchants.addEnchant(this, CustomEnchants.HOLDING, 0).getItemMeta());
                            }
                        });
                    }
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Holding";
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {

        if (itemStack.getType().equals(Material.BOOK) || itemStack.getType().equals(Material.EMERALD) || itemStack.getType().equals(Material.ENCHANTED_BOOK)) {
            if (itemStack.getType().equals(Material.ENCHANTED_BOOK)) {
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) itemStack.getItemMeta();

                if (meta.getStoredEnchants().size() <= 1) {
                    if (meta.getStoredEnchants().size() == 1) {
                        return (CustomEnchants.hasEnchantment(itemStack, this));
                    }
                    return true;
                } else {
                    return false;
                }

            } else {
                if (itemStack.getEnchantments().size() <= 1) {
                    if (itemStack.getEnchantments().size() == 1) {
                        return (CustomEnchants.hasEnchantment(itemStack, this));
                    }

                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }
}
