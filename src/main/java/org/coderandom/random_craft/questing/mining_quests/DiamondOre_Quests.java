package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class DiamondOre_Quests extends BaseQuest {
    public DiamondOre_Quests() {
        super("diamond_ore_quests", "§3Diamond Quests§6!", "Advanced by mining diamond ore.", Material.DIAMOND_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.customEnchantBook("§eFortune Scroll§6!", new HashMap<>(){
            {
                put(Enchantment.LOOT_BONUS_BLOCKS, 3);
            }
        }, "Hidden knowledge..."));

        addRewards(9 * 64, ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64,
                ItemUtil.mendy()
        );

        addRewards(32 * 64, ItemUtil.newItem(Material.DIAMOND,
                "§bRiches Class Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " diamond ore.",
                "Item frame trophy!")
        );

        addRewards(64 * 64, ItemUtil.newItem(Material.DIAMOND_BLOCK,
                "§b1% Richest Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " diamond ore.",
                "Item frame trophy!")
        );
    }
}
