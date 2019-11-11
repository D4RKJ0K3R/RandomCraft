package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Bat_Quests extends BaseQuest {
    public Bat_Quests() {
        super("bat_quests", "§4Bat Quests§6!", "Advanced by hunting bats.", Statistic.KILL_ENTITY, EntityType.BAT);
    }
}
