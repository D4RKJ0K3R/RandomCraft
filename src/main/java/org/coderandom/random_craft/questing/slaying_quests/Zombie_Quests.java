package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Zombie_Quests extends BaseQuest {
    public Zombie_Quests() {
        super("zombie_slaying_quest", "§2Zombie Quests§6!", "Advanced by slaying zombies!", Statistic.KILL_ENTITY, EntityType.ZOMBIE);
    }
}
