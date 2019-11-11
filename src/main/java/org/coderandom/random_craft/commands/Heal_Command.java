package org.coderandom.random_craft.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.coderandom.random_craft.RandomCraft;

public class Heal_Command implements CommandExecutor {
    public Heal_Command() {
        RandomCraft.add("heal", this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (args.length == 0) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                player.setHealth(player.getHealthScale());
                player.getActivePotionEffects().forEach(effect -> {
                    if (effect.getType().equals(PotionEffectType.HERO_OF_THE_VILLAGE)) {
                        return;
                    }
                    player.removePotionEffect(effect.getType());
                });
                player.sendMessage("§2Healed§6!");
                return true;
            } else {
                return false;
            }
        } else if (args.length == 1 && sender.hasPermission("randomcraft.heal.other")) {
            Player target = Bukkit.getPlayer(args[0]);

            if (target != null) {
                target.setHealth(target.getHealthScale());
                target.getActivePotionEffects().forEach(effect -> {
                    if (effect.getType().equals(PotionEffectType.HERO_OF_THE_VILLAGE)) {
                        return;
                    }
                    target.removePotionEffect(effect.getType());
                });
                sender.sendMessage(args[0] + "§2 healed§6!");
                target.sendMessage("§2Healed by §r" + sender.getName() + "§6!");
                return true;
            } else {
                sender.sendMessage(args[0] + "§4 not found§6!");
            }
        }
        return false;
    }
}
