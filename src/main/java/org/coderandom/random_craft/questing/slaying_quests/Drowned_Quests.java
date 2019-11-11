package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Drowned_Quests extends BaseQuest {
    public Drowned_Quests() {
        super("drowned_slaying_quest", "§3Drowned Quests§6!", "Advanced by slaying the drowned!", Statistic.KILL_ENTITY, EntityType.DROWNED);
    }
}
