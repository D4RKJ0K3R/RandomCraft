package org.coderandom.random_craft.player_homes.commands;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.coderandom.random_craft.RandomCraft;

import java.util.Map;

public class Homes implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 0) {
                sendHomes(player, player);
                return true;
            } else if(args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);

                if (target != null) {
                    sendHomes(player, target);
                    return true;
                } else {
                    sender.sendMessage("§4Couldn§6'§4t find player §r" + args[0] + "§6!");
                }
            }
        } else {
            sender.sendMessage("§4Must be a player to perform this command§6!");
        }
        return false;
    }

    private void sendHomes(Player player, Player target) {
        Map<String, Object> homes = RandomCraft.getPlayerHomes().getHomes(target.getUniqueId());

        ComponentBuilder component = new ComponentBuilder("§6[§2Homes§6]");

        homes.forEach((name, object) -> {
            Location location = Location.deserialize((Map<String, Object>) object);
            HoverEvent hoverEvent = new HoverEvent(HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("§2World§6: §r" + location.getWorld().getName() +
                    "\n§2X§6: §r" + location.getX() +
                    "\n§2Y§6: §r" + location.getY() +
                    "\n§2Z§6: §r" + location.getZ())
                    .create());

            ClickEvent clickEvent;

            ComponentBuilder subComponent = new ComponentBuilder("\n§r" + name + "§6:").event(hoverEvent);

            if (player != target) {
                clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/home " + target.getName() + " " + name);
                subComponent.append(new ComponentBuilder(" §6[§2Teleport§6] ").event(clickEvent).create());

                clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/delhome " + target.getName() + " " + name);
                subComponent.append(new ComponentBuilder(" §6[§4Delete§6] ").event(clickEvent).create());
            } else {
                clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/home " + name);
                subComponent.append(new ComponentBuilder(" §6[§2Teleport§6] ").event(clickEvent).create());

                clickEvent = new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/delhome " + name);
                subComponent.append(new ComponentBuilder(" §6[§4Delete§6] ").event(clickEvent).create());
            }
            component.append(subComponent.create());
        });

        player.spigot().sendMessage(component.create());
    }
}