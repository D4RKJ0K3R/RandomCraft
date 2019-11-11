package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class RaidWin_Quests extends BaseQuest {
    public RaidWin_Quests() {
        super("raid_win_quests", "§2Raid Winning Quests§6!", "Advanced by protecting villagers from those pesky pillagers!", Statistic.RAID_WIN, EntityType.PILLAGER);
    }
}
