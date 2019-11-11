package org.coderandom.random_craft.player_homes.commands;

import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coderandom.random_craft.RandomCraft;

import java.util.UUID;

public class SetHome implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                setHome(player, player, "DEFAULT");
                return true;
            } else if (args.length == 1) {
                setHome(player, player, args[0]);
                return true;
            } else if (args.length == 2) {

                if (sender.hasPermission("randomcore.homes.other")){
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        setHome(player, target, args[1]);
                        return true;
                    } else {
                        sender.sendMessage("§4Couldn§6'§4t find player §r" + args[0] + "§6!");
                    }
                } else {
                    sender.sendMessage("§4You don§6'§4t have permission to set other players homes§6!");
                }
            }

        } else {
            sender.sendMessage("§4Must be a player to perform this command§6!");
        }
        return false;
    }

    private void setHome(Player player, Player target, String name) {
        UUID uuid = target.getUniqueId();

        if (RandomCraft.getPlayerHomes().isHomeSet(uuid, name)) {
            BaseComponent[] component = new ComponentBuilder("§4Home §r" + name + "§4 already set§6!  ")
                    .append(new ComponentBuilder("§6[§2Teleport§6] ").event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/home " + name)).create())
                    .append(new ComponentBuilder(" §6[§4Remove§6]").event(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/delhome " + name)).create())
                    .create();

            player.spigot().sendMessage(component);
        } else {
            RandomCraft.getPlayerHomes().setHome(uuid, name, player.getLocation());
            player.sendMessage(name + "§2 set§6!");
        }
    }
}
