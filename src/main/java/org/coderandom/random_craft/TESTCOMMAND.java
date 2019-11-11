package org.coderandom.random_craft;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class TESTCOMMAND implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        ((Player) sender).getInventory().addItem(ItemUtil.newItem(Material.CROSSBOW, "§2UltimateCrossBow§6!", true,
                new HashMap<>(){
                    {
                        put(Enchantment.QUICK_CHARGE, 3);
                        put(Enchantment.MULTISHOT, 1);
                        put(Enchantment.PIERCING, 4);
                    }
                }));
        ((Player) sender).getInventory().addItem(new ItemStack(Material.ARROW, 64));
        ((Player) sender).getInventory().addItem(new ItemStack(Material.ARROW, 64));

//        ItemStack newBanner = new ItemStack(BANNER)
        return false;
    }
}
