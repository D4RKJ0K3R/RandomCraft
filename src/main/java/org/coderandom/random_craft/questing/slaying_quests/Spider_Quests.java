package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Spider_Quests extends BaseQuest {
    public Spider_Quests() {
        super("spider_slaying_quest", "§4Spider Quests§6!", "Advanced by slaying spiders!", Statistic.KILL_ENTITY, EntityType.SPIDER);
    }
}
