package org.coderandom.random_craft.questing.nether_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Blaze_Quests extends BaseQuest {
    public Blaze_Quests() {
        super("blaze_slaying_quest", "§6Blaze Quests§6!", "Advanced by slaying blazes!", Statistic.KILL_ENTITY, EntityType.BLAZE);
    }
}
