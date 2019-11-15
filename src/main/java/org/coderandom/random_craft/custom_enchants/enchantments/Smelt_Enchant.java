package org.coderandom.random_craft.custom_enchants.enchantments;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

import java.util.ArrayList;

public class Smelt_Enchant extends CustomWrapper {
    public Smelt_Enchant() {
        super("smelting", new ArrayList<>(){
            {
                add(Material.GOLDEN_PICKAXE);
                add(Material.IRON_PICKAXE);
                add(Material.DIAMOND_PICKAXE);
            }
        });
    }

    @Override
    public String getName() {
        return "Smelting";
    }

    @EventHandler
    public void event(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        ItemStack tool = player.getInventory().getItemInMainHand();

        if (CustomEnchants.hasEnchantment(tool, Enchantment.SILK_TOUCH)) {
            return;
        }

        if (CustomEnchants.canUseEnchant(tool, this)) {
            switch (block.getType()) {
                case IRON_ORE:
                    event.setDropItems(false);
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.IRON_INGOT));
                    break;
                case GOLD_ORE:
                    event.setDropItems(false);
                    block.getWorld().dropItemNaturally(block.getLocation(), new ItemStack(Material.GOLD_INGOT));
                    break;
                default:
            }
        }
    }
}
