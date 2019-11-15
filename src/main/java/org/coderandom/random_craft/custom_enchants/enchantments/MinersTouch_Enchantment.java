package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.Container;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;
import org.coderandom.random_craft.utils.Utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.UUID;

public class MinersTouch_Enchantment extends CustomWrapper {

    private static HashMap<UUID, Integer> buffer;
    private static ArrayList<UUID> hasTelekinesis;

    public MinersTouch_Enchantment() {
        super("miners_touch", EnchantmentTarget.CROSSBOW, EnchantmentTarget.BOW);
        CustomEnchants.register(this);
        buffer = new HashMap<>();
        hasTelekinesis = new ArrayList<>();
    }

    @Override
    public String getName() {
        return "Miners Touch";
    }

    @EventHandler
    private void event(ProjectileHitEvent event) {
        if (event.getEntity().getShooter() instanceof Player) {
            Player player = ((Player) event.getEntity().getShooter()).getPlayer();
            if (buffer.containsKey(event.getEntity().getUniqueId())) {
                buffer.remove(event.getEntity().getUniqueId());

                if (event.getHitBlock() != null) {
                    Block block = event.getHitBlock();
                    Collection<ItemStack> drops = block.getDrops();

                    if (block.getType().equals(Material.BEDROCK) || block.getType().toString().contains("DOOR")) {
                        return;
                    }

                    if (hasTelekinesis.contains(event.getEntity().getUniqueId())) {
                        hasTelekinesis.remove(event.getEntity().getUniqueId());
                        if (player == null) {
                            return;
                        }

                        if (block.getState() instanceof Container && !block.getType().equals(Material.ENDER_CHEST)) {
                            Container container = (Container) block.getState();

                            ItemStack[] contents = container.getInventory().getContents();

                            for (int i = 0; i < contents.length; i++) {
                                if (contents[i] != null) {
                                    if (Utils.emptySlots(player) > 0) {
                                        player.getInventory().addItem(contents[i]);
                                    } else {
                                        player.getWorld().dropItemNaturally(player.getLocation(), contents[i]);
                                    }
                                }
                            }
                            container.getInventory().clear();
                        }

                        block.setType(Material.AIR);
                        block.getWorld().playSound(block.getLocation(), Sound.ENTITY_SHULKER_TELEPORT, 1, 1);
                        block.getWorld().playEffect(block.getLocation(), Effect.ENDER_SIGNAL, 1);

                        drops.forEach(drop -> {
                            if (Utils.emptySlots(player) > 0) {
                                player.getInventory().addItem(drop);
                                player.updateInventory();
                                player.getWorld().playSound(player.getLocation(), Sound.ENTITY_ITEM_PICKUP, 1, 1);
                            } else {
                                player.getWorld().dropItemNaturally(player.getLocation(), drop);
                            }
                        });
                    } else {
                        block.getWorld().playSound(block.getLocation(), Sound.BLOCK_STONE_BREAK, 1, 1);
                        block.breakNaturally();
                    }
                }

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
                ((Arrow) event.getEntity()).setColor(Color.GREEN);
                event.getEntity().setGlowing(true);
                event.getEntity().setBounce(false);

                if (CustomEnchants.canUseEnchant(tool, CustomEnchants.TELEKINESIS)) {
                    hasTelekinesis.add(event.getEntity().getUniqueId());
                }
            }
        }
    }
}
