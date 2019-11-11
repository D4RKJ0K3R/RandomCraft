package org.coderandom.random_craft.player_homes.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coderandom.random_craft.RandomCraft;

import java.util.UUID;

public class DeleteHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                delHome(player, player, "DEFAULT");
                return true;
            } else if (args.length == 1) {
                delHome(player, player, args[0]);
                return true;
            } else if (args.length == 2) {

                if (sender.hasPermission("randomcore.homes.other")){
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        delHome(player, target, args[1]);
                        return true;
                    } else {
                        sender.sendMessage("§4Couldn§6'§4t find player §r" + args[1] + "§6!");
                    }
                } else {
                    sender.sendMessage("§4You don§6'§4t have permission to delete other players homes§6!");
                }
            }

        } else {
            sender.sendMessage("§4Must be a player to perform this command§6!");
        }
        return false;
    }

    private void delHome(Player player, Player target, String name) {
        UUID uuid = target.getUniqueId();

        if (RandomCraft.getPlayerHomes().isHomeSet(uuid, name)) {
            RandomCraft.getPlayerHomes().removeHome(uuid, name);
            player.sendMessage(name + "§2 deleted§6!");
        } else {
            player.sendMessage(name + "§4 not set§6!");
        }
    }
}