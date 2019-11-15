package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class CustomWrapper extends Enchantment implements Listener {
    private int max;
    private int start;
    private ArrayList<EnchantmentTarget> enchantmentTarget;
    private List<Material> exceptions;

    public CustomWrapper(String nameSpace, int startLevel, int maxLevel, List<Material> exceptions, EnchantmentTarget... enchantmentTarget) {
        super(new NamespacedKey(RandomCraft.getInstance(), nameSpace));
        this.start = startLevel;
        this.max = maxLevel;
        this.exceptions = exceptions;
        this.enchantmentTarget = new ArrayList<>(){
            {
                addAll(Arrays.asList( enchantmentTarget));
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
        return enchantmentTarget.get(0);
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

        enchantmentTarget.forEach(target ->  {
            if (target.includes(itemStack)) {
                canEnchant.getAndSet(true);
            }
        });

        if (exceptions.size() > 0 && !canEnchant.get()) {
            canEnchant.getAndSet(exceptions.contains(itemStack.getType()));
        }

        return canEnchant.get();
    }
}
