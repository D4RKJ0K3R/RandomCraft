package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Squid_Quests extends BaseQuest {
    public Squid_Quests() {
        super("squid_quests", "§7Squid Quests§6!", "Advanced by hunting squids.", Statistic.KILL_ENTITY, EntityType.SQUID);
    }
}
