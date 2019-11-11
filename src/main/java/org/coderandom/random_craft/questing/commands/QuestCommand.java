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

public class QuestCommand implements CommandExecutor, TabCompleter {

    public QuestCommand() {
        RandomCraft.add("quest", this, this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (args.length == 1) {
                QuestManager.getQuestByID(args[0]).openGUI(player);
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
            Player player = (Player) sender;
            List<String> list = QuestManager.listQuests();

            if (args.length == 1) {
                return StringUtil.copyPartialMatches(args[0], list, new ArrayList<>());
            }
        }
        return null;
    }
}
