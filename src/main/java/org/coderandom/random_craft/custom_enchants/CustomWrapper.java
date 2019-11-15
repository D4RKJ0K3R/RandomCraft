package org.coderandom.random_craft.custom_enchants;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.utils.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CustomWrapper extends Enchantment implements Listener {
    private int max;
    private int start;
    private ArrayList<EnchantmentTarget> enchantmentTargets;
    private List<Material> exceptions;

    public CustomWrapper(String nameSpace, int startLevel, int maxLevel, EnchantmentTarget... enchantmentTargets) {
        this(nameSpace, startLevel, maxLevel, null, enchantmentTargets);
    }

    public CustomWrapper(String nameSpace, EnchantmentTarget... enchantmentTargets) {
        this(nameSpace, 1, 1, null, enchantmentTargets);
    }

    public CustomWrapper(String nameSpace, List<Material> exceptions, EnchantmentTarget... enchantmentTargets) {
        this(nameSpace, 1, 1, exceptions, enchantmentTargets);
    }

    public CustomWrapper(String nameSpace, int startLevel, int maxLevel, List<Material> exceptions, EnchantmentTarget... enchantmentTargets) {
        super(new NamespacedKey(RandomCraft.getInstance(), nameSpace));
        this.start = startLevel;
        this.max = maxLevel;
        this.exceptions = Objects.requireNonNullElseGet(exceptions, ArrayList::new);

        this.enchantmentTargets = new ArrayList<>(){
            {
                addAll(Arrays.asList( enchantmentTargets));
            }
        };

        Bukkit.getPluginManager().registerEvents(this, RandomCraft.getInstance());
    }

    @EventHandler
    public void disable(PluginDisableEvent event) {
        if (event.getPlugin().getName().equals(RandomCraft.getInstance().getName())) {
            CustomEnchants.unRegister(this);
        }
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return enchantmentTargets.get(0);
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public int getMaxLevel() {
        return max;
    }

    @Override
    public int getStartLevel() {
        return start;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        AtomicBoolean canEnchant = new AtomicBoolean(false);

        if (itemStack.getType().equals(Material.BOOK) || itemStack.getType().equals(Material.EMERALD) || itemStack.getType().equals(Material.ENCHANTED_BOOK)){
            return !CustomEnchants.hasEnchantment(itemStack, CustomEnchants.HOLDING);
        }

        enchantmentTargets.forEach(target ->  {
            if (target.includes(itemStack)) {
                canEnchant.getAndSet(true);
            }
        });

        if (exceptions.size() > 0 && !canEnchant.get()) {
            canEnchant.getAndSet(exceptions.contains(itemStack.getType()));
        }

        return canEnchant.get();
    }

    public abstract static class SpawnerWrapper extends CustomWrapper {
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
}
