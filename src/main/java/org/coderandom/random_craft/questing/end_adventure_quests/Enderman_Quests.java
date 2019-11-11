package org.coderandom.random_craft.questing.end_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Enderman_Quests extends BaseQuest {
    public Enderman_Quests() {
        super("enderman_slaying_quest", "§5Enderman Quests§6!", "Advanced by slaying endermen!", Statistic.KILL_ENTITY, EntityType.ENDERMAN);
    }
}
