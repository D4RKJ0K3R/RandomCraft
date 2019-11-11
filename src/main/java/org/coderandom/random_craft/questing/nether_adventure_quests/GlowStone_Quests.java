package org.coderandom.random_craft.questing.nether_adventure_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.coderandom.random_craft.questing.BaseQuest;

public class GlowStone_Quests extends BaseQuest {
    public GlowStone_Quests() {
        super("glowstone_quests", "§eGlowstone Quests§6!", "Advanced by mining glowstone!", Material.GLOWSTONE, Statistic.MINE_BLOCK);
    }
}
