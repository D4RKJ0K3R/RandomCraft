package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Sheep_Quests extends BaseQuest {
    public Sheep_Quests() {
        super("sheep_quests", "§rSheep Quests§6!", "Advanced by hunting sheep.", Statistic.KILL_ENTITY, EntityType.SHEEP);
    }
}
