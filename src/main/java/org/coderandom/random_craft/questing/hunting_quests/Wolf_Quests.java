package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Wolf_Quests extends BaseQuest {
    public Wolf_Quests() {
        super("wolf_quests", "§7Wolf Quests§6!", "Advanced by hunting wolves!", Statistic.KILL_ENTITY, EntityType.WOLF);
    }
}
