package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class VillagerTrade_Quests extends BaseQuest {
    public VillagerTrade_Quests() {
        super("villager_trade_quests", "§2Villager Trading Quests§6!", "Advanced by trading with villagers!", Statistic.TRADED_WITH_VILLAGER, EntityType.VILLAGER);
    }
}
