package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Color;
import org.bukkit.Sound;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

import java.util.HashMap;
import java.util.UUID;

public class Explosive_Enchantment extends CustomWrapper {

    private static HashMap<UUID, Integer> buffer;

    public Explosive_Enchantment() {
        super("explosive", 1, 3, EnchantmentTarget.CROSSBOW, EnchantmentTarget.BOW);
        CustomEnchants.register(this);
        buffer = new HashMap<>();
    }

    @Override
    public String getName() {
        return "Explosive";
    }

    @EventHandler
    private void event(ProjectileHitEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player player = ((Player) event.getEntity().getShooter()).getPlayer();
            if (buffer.containsKey(event.getEntity().getUniqueId())) {
                TNTPrimed primed = (TNTPrimed) event.getEntity().getWorld().spawnEntity(event.getEntity().getLocation(), EntityType.PRIMED_TNT);
                primed.setGravity(false);
                primed.setYield(buffer.get(event.getEntity().getUniqueId()));
                primed.setVelocity(new Vector());
                primed.getWorld().playSound(primed.getLocation(), Sound.ENTITY_TNT_PRIMED, 1, 1);
                primed.getWorld().playSound(player.getLocation(), Sound.ENTITY_TNT_PRIMED, 1, 1);
                primed.setFuseTicks(0);

                buffer.remove(event.getEntity().getUniqueId());
                event.getEntity().remove();
            }
        }
    }

    @EventHandler
    private void event(ProjectileLaunchEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            ItemStack tool = ((Player) event.getEntity().getShooter()).getInventory().getItemInMainHand();
            if (CustomEnchants.canUseEnchant(tool, this)) {
                buffer.put(event.getEntity().getUniqueId(), CustomEnchants.getLevel(tool, this));
                ((Arrow) event.getEntity()).setColor(Color.RED);
                event.getEntity().setGlowing(true);
                event.getEntity().setBounce(false);
            }
        }
    }
}
