package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.enchantments.CustomWrapper;
import org.coderandom.random_craft.utils.Utils;

import java.util.ArrayList;

public abstract class SpawnerWrapper extends CustomWrapper {
    private EntityType entityType;
    public SpawnerWrapper(EntityType entityType) {
        super(entityType.name(), 1, 1, new ArrayList<>() { { add(Material.SPAWNER); } });
        this.entityType = entityType;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        if (event.getBlock().getType().equals(Material.SPAWNER)) {
            CreatureSpawner spawner = (CreatureSpawner) event.getBlockPlaced().getState();
            ItemStack item = event.getItemInHand();

            if (CustomEnchants.hasEnchantment(item, this)) {
                spawner.setSpawnedType(getEntityType());
                spawner.update(true);
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (event.getBlock().getType().equals(Material.SPAWNER)) {
            CreatureSpawner spawner = (CreatureSpawner) event.getBlock().getState();
            Player player = event.getPlayer();
            ItemStack tool = player.getInventory().getItemInMainHand();

            if (spawner.getSpawnedType().equals(getEntityType())) {
                event.setDropItems(false);

                if (CustomEnchants.hasEnchantment(tool, SILK_TOUCH)) {
                    event.setExpToDrop(0);
                    Enchantment enchantment = this;

                    ItemStack item = new ItemStack(Material.SPAWNER) {
                        {
                            setItemMeta(CustomEnchants.addEnchant(this, enchantment, 1).getItemMeta());
                        }
                    };

                    if (CustomEnchants.hasEnchantment(tool, CustomEnchants.TELEKINESIS)) {
                        if (Utils.emptySlots(event.getPlayer()) > 0) {
                            event.getPlayer().getInventory().addItem(item);
                        } else {
                            event.getPlayer().getWorld().dropItemNaturally(event.getPlayer().getLocation(), item);
                        }
                    } else {
                        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), item);
                    }
                } else {
                    if (CustomEnchants.hasEnchantment(tool, CustomEnchants.TELEKINESIS)) {
                        if (event.getExpToDrop() > 0) {
                            if (CustomEnchants.hasMending(player)) {
                                ExperienceOrb orb = (ExperienceOrb) player.getWorld().spawnEntity(player.getLocation(), EntityType.EXPERIENCE_ORB);
                                orb.setExperience(event.getExpToDrop());
                            } else {
                                player.giveExp(event.getExpToDrop());
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
                            }
                            event.setExpToDrop(0);
                        }
                    }
                }
            }
        }
    }
}
