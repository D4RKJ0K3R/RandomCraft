package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Cow_Quests extends BaseQuest {
    public Cow_Quests() {
        super("cow_quests", "§7Cow Quests§6!", "Advanced by hunting cows.", Statistic.KILL_ENTITY, EntityType.COW);
    }
}
