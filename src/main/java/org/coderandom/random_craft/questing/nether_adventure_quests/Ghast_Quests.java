package org.coderandom.random_craft.questing.nether_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Ghast_Quests extends BaseQuest {
    public Ghast_Quests() {
        super("ghast_slaying_quest", "§7Ghast Quests§6!", "Advanced by slaying ghasts!", Statistic.KILL_ENTITY, EntityType.GHAST);
    }
}
