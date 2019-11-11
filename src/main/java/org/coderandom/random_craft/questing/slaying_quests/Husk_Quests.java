package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Husk_Quests extends BaseQuest {
    public Husk_Quests() {
        super("husk_slaying_quest", "§eHusk Quests§6!", "Advanced by slaying husks!", Statistic.KILL_ENTITY, EntityType.HUSK);
    }
}
