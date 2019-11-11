package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Chicken_Quests extends BaseQuest {
    public Chicken_Quests() {
        super("chicken_quests", "§cChicken Quests§6!", "Advanced by hunting chickens.", Statistic.KILL_ENTITY, EntityType.CHICKEN);
    }
}
