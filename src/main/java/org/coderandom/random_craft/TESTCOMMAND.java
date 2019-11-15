package org.coderandom.random_craft;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class TESTCOMMAND implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        ((Player) sender).getInventory().addItem(new ItemStack(Material.EMERALD, 64) {
            {
                ItemMeta meta = CustomEnchants.addEnchant(this, CustomEnchants.spawnerEnchant(EntityType.SILVERFISH), 1).getItemMeta();
                setItemMeta(meta);
            }
        });

        return false;
    }
}
