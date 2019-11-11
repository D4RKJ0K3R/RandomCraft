package org.coderandom.random_craft.questing.end_adventure_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.coderandom.random_craft.questing.BaseQuest;

public class Endstone_Quests extends BaseQuest {
    public Endstone_Quests() {
        super("endstone_quests", "§rEndstone Quests§6!", "Advanced by harvesting endstone!", Material.END_STONE, Statistic.MINE_BLOCK);
    }
}
