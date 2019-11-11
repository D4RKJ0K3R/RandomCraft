package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Creeper_Quests extends BaseQuest {
    public Creeper_Quests() {
        super("creeper_slaying_quest", "§2Creeper Quests§6!", "Advanced by slaying creepers!", Statistic.KILL_ENTITY, EntityType.CREEPER);
    }
}
