package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class ZombieVillager_Quests extends BaseQuest {
    public ZombieVillager_Quests() {
        super("zombie_villager_slaying_quest", "§2Zombie Villager Quests§6!", "Advanced by slaying zombie villagers", Statistic.KILL_ENTITY, EntityType.ZOMBIE_VILLAGER);
    }
}
