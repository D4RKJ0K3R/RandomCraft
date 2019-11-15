package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

import java.util.ArrayList;
import java.util.UUID;

public class Ender_Enchantment extends CustomWrapper {
    private static ArrayList<UUID> buffer;

    public Ender_Enchantment() {
        super("ender", 1, 1,new ArrayList<>(), EnchantmentTarget.CROSSBOW, EnchantmentTarget.BOW);
        CustomEnchants.register(this);
        buffer = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "Ender";
    }

    @EventHandler
    private void event(ProjectileHitEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player player = ((Player) event.getEntity().getShooter()).getPlayer();
            if (buffer.contains(event.getEntity().getUniqueId())) {
                buffer.remove(event.getEntity().getUniqueId());
                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
                player.getWorld().playEffect(player.getLocation(), Effect.ENDER_SIGNAL, 1);
                player.teleport(event.getEntity().getLocation());
                event.getEntity().remove();
                player.getWorld().playSound(event.getEntity().getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
                player.getWorld().playEffect(event.getEntity().getLocation(), Effect.ENDER_SIGNAL, 1);
            }
        }
    }

    @EventHandler
    private void event(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            ItemStack tool = ((Player) event.getEntity().getShooter()).getInventory().getItemInMainHand();
            if (CustomEnchants.canUseEnchant(tool, this)) {
                buffer.add(event.getEntity().getUniqueId());
                ((Arrow) event.getEntity()).setColor(Color.PURPLE);
                event.getEntity().setGlowing(true);
                event.getEntity().setBounce(false);
            }
        }
    }
}
