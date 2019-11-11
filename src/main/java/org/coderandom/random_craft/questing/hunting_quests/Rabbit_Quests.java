package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Rabbit_Quests extends BaseQuest {
    public Rabbit_Quests() {
        super("rabbit_quests", "§6Rabbit Quests§6!", "Advanced by hunting rabbits.", Statistic.KILL_ENTITY, EntityType.RABBIT);
    }
}
