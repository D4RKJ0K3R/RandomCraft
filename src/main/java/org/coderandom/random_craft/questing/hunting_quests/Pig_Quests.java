package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Pig_Quests extends BaseQuest {
    public Pig_Quests() {
        super("pig_quests", "§dPig Quests§6!", "Advanced by hunting pigs.", Statistic.KILL_ENTITY, EntityType.PIG);
    }
}
