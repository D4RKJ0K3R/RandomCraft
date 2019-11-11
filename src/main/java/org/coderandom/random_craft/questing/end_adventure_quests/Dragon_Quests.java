package org.coderandom.random_craft.questing.end_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Dragon_Quests extends BaseQuest {
    public Dragon_Quests() {
        super("dragon_slaying_quest", "§5Dragon Slaying Quests§6!", "Advanced by slaying the ender dragon!", Statistic.KILL_ENTITY, EntityType.ENDER_DRAGON);
    }
}
