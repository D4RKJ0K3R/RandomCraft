package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Fishing_Quests extends BaseQuest {
    public Fishing_Quests() {
        super("fishing_quests", "§9Fishing Quests§6!", "Advanced by catching fish!", Statistic.FISH_CAUGHT, EntityType.COD);
    }
}
