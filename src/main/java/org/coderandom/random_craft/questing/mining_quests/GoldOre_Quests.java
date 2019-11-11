package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class GoldOre_Quests extends BaseQuest {

    public GoldOre_Quests() {
        super("gold_ore_quests", "§6Gold Ore Quests§4!", "Advanced by mining gold ore.", Material.GOLD_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64,
                ItemUtil.mendy()
        );

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64, ItemUtil.mendy());

        addRewards(32 * 64, ItemUtil.newItem(Material.GOLD_INGOT,
                "§6In Business Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " gold ore.",
                "Item frame trophy!")
        );

        addRewards(64 * 64, ItemUtil.newItem(Material.GOLD_BLOCK,
                "§6Rags To Riches Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " gold ore.",
                "Item frame trophy!")
        );
    }
}