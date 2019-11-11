package org.coderandom.random_craft.questing.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.questing.QuestManager;

import java.util.ArrayList;
import java.util.List;

public class QuestsCommand implements CommandExecutor, TabCompleter {
    public QuestsCommand() {
        RandomCraft.add("quests", this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                String arg = args[0];
                if (arg.equalsIgnoreCase("adventure")) {
                    QuestManager.getAdventureQuests().openUI(player);
                } else if (arg.equalsIgnoreCase("crafting")) {
                    QuestManager.getCraftingQuests().openUI(player);
                } else if (arg.equalsIgnoreCase("mining")) {
                    QuestManager.getMiningQuests().openUI(player);
                } else if (arg.equalsIgnoreCase("hunting")) {
                    QuestManager.getHuntingQuests().openUI(player);
                } else if (arg.equalsIgnoreCase("slaying")) {
                    QuestManager.getSlayingQuests().openUI(player);
                }
                return true;
            } else if (args.length == 0) {
                QuestManager.openUI(player);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            List<String> list = new ArrayList<>(){
                {
                    add("Adventure");
                    add("Crafting");
                    add("Mining");
                    add("Hunting");
                    add("Slaying");
                }
            };

            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], list, new ArrayList<>());
            }
        }
        return null;
    }
}
