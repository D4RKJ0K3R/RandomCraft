package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class Stone_Quests extends BaseQuest {

    public Stone_Quests() {
        super("stone_quests", "§7Stone Quests§6!", "Advanced by mining stone.", Material.STONE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.newItem(Material.GOLDEN_PICKAXE,
                "§6Goldy The Terrible§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.DIG_SPEED, 1);
                        put(Enchantment.LOOT_BONUS_BLOCKS, 1);
                    }
                },
                "Good for mining stone and coal...")
        );

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(8)
        );

        addRewards(16 * 64,
                ItemUtil.mendy()
        );

        addRewards(32 * 64, ItemUtil.newItem(Material.COBBLESTONE,
                "§7Cobble Crusher Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " stone.",
                "Item frame trophy!")
        );

        addRewards(64 * 64, ItemUtil.newItem(Material.STONE,
                "§7Stone Smasher Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " stone.",
                "Item frame trophy!")
        );
    }
}
