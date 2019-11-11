package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Pigman_Quests extends BaseQuest {
    public Pigman_Quests() {
        super("pigman_slaying_quest", "§dZombie Pigman Quests§6!", "Advanced by slaying zombie pigmen.", Statistic.KILL_ENTITY, EntityType.PIG_ZOMBIE);
    }
}
