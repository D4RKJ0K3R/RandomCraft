package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class NightVision_Enchantment extends CustomWrapper {
    public NightVision_Enchantment() {
        super("night_vision", EnchantmentTarget.ARMOR_HEAD);
        CustomEnchants.register(this);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getOnlinePlayers().forEach(player -> {
                    if (player.getInventory().getHelmet() != null && !player.getInventory().getHelmet().getType().equals(Material.AIR)) {
                        ItemStack helmet = player.getInventory().getHelmet();

                        if (CustomEnchants.hasEnchantment(helmet, CustomEnchants.NIGHTVISION)) {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 61 * 20, 0, true, false, false), true);
                        }
                    }

                });
            }
        }.runTaskTimer(RandomCraft.getInstance(), 0, 10);
    }

    @Override
    public String getName() {
        return "Night Vision";
    }
}
