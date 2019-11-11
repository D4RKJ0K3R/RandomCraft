package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.entity.Player;
import org.coderandom.random_craft.questing.QuestManager;

public class QuestMenu {
    public static void openQuestUI(String ID, Player player) {
        QuestManager.getQuestByID(ID).openGUI(player);
    }
}
