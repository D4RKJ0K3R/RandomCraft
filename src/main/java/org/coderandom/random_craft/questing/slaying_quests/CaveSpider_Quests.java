package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class CaveSpider_Quests extends BaseQuest {
    public CaveSpider_Quests() {
        super("cave_spider_slaying_quest", "§aCave Spider Quests§6!", "Advanced by slaying cave spiders!", Statistic.KILL_ENTITY, EntityType.CAVE_SPIDER);
    }
}
