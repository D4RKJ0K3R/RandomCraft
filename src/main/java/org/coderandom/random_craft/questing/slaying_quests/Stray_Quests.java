package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Stray_Quests extends BaseQuest {
    public Stray_Quests() {
        super("stray_slaying_quest", "§3Stray Quests§6!", "Advanced by slaying stray skeletons!", Statistic.KILL_ENTITY, EntityType.STRAY);
    }
}
