package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Slime_Quests extends BaseQuest {
    public Slime_Quests() {
        super("slime_slaying_quest", "§aSlime Quests§6!", "Advanced by slaying slimes!", Statistic.KILL_ENTITY, EntityType.SLIME);
    }
}
