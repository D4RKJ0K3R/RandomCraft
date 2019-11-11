package org.coderandom.random_craft.player_homes.commands.tab_completers;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.coderandom.random_craft.RandomCraft;

import java.util.ArrayList;
import java.util.List;

public class HomesTabCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            List<String> list = null;

            if (args.length == 1) {
                list = RandomCraft.getPlayerHomes().getHomesList(player.getUniqueId());

                if (player.hasPermission("randomcore.homes.other")) {
                    Object[] online = Bukkit.getOnlinePlayers().toArray();

                    for (Object onlinePlayer : online) {
                        list.add(((Player) onlinePlayer).getName());
                    }
                }

                 return StringUtil.copyPartialMatches(args[0], list, new ArrayList<>());
            } else if (args.length == 2) {
                if (player.hasPermission("randomcore.homes.other")) {
                    Player target = Bukkit.getPlayer(args[0]);

                    if (target != null) {
                        list = RandomCraft.getPlayerHomes().getHomesList(target.getUniqueId());
                        return StringUtil.copyPartialMatches(args[1], list, new ArrayList<>());
                    }
                }
            }
        }
        return null;
    }
}
