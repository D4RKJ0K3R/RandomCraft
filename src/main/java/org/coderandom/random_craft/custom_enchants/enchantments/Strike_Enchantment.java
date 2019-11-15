package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class Strike_Enchantment extends CustomWrapper {
    public Strike_Enchantment() {
        super("strike", 1, 3, EnchantmentTarget.BOW, EnchantmentTarget.CROSSBOW);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Strike";
    }

    @EventHandler
    public void event(EntityDeathEvent event) {
        if (event.getEntity().getKiller() != null) {
            Player player = event.getEntity().getKiller();

            if (!event.getEntity().getKiller().getInventory().getItemInMainHand().getType().equals(Material.AIR)) {
                ItemStack tool = player.getInventory().getItemInMainHand();

                if (CustomEnchants.canUseEnchant(tool, this)) {
                    for (int i = 0; i < CustomEnchants.getLevel(tool, this); i++) {
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.LIGHTNING);
                            }
                        }.runTaskLater(RandomCraft.getInstance(), i * 10);
                    }
                }
            }
        }
    }
}
