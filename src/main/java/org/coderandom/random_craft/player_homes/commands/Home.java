package org.coderandom.random_craft.player_homes.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coderandom.random_craft.RandomCraft;

public class Home implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                teleportToHome(player, player, "DEFAULT");
                return true;
            } else if (args.length == 1){
                teleportToHome(player, player, args[0]);
                return true;
            } else if (args.length == 2) {
                if (player.hasPermission("randomcore.homes.other")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        teleportToHome(player, target, args[1]);
                        return true;
                    } else {
                        sender.sendMessage("§4Couldn§6'§4t find player §r" + args[0] + "§6!");
                    }
                } else {
                    sender.sendMessage("§4You don§6'§4t have permission to teleport to other players homes§6!");
                }
            }
        } else {
            sender.sendMessage("§4Must be a player to perform this command§6!");
        }
        return false;
    }

    private void teleportToHome(Player player, Player target, String name) {
        if (RandomCraft.getPlayerHomes().isHomeSet(target.getUniqueId(), name)) {
            RandomCraft.addTeleport(player, RandomCraft.getPlayerHomes().getHome(target.getUniqueId(), name), 3);
        } else {
            player.sendMessage("§4Home §r" + name + "§4 doesn§6'§4t exist§6!");
        }
    }
}
