package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class LapisOre_Quests extends BaseQuest {

    public LapisOre_Quests() {
        super("lapis_ore_quests", "§1Lapis Lazuli Quests§6!", "Advanced by mining lapis ore.", Material.LAPIS_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.mendy());

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(8)
        );

        addRewards(16 * 64, ItemUtil.customEnchantBook("§6Miners Hidden Secret's!",
                new HashMap<>(){
                    {
                        put(Enchantment.DIG_SPEED, 7);
                        put(Enchantment.DURABILITY, 5);
                        put(Enchantment.LOOT_BONUS_BLOCKS, 5);
                    }
                }));

        addRewards(32 * 64, ItemUtil.newItem(Material.LAPIS_LAZULI,
                "§1Journey To Magic Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " lapis ore.",
                "Item frame trophy!")
        );

        addRewards(48 * 64, ItemUtil.customEnchantBook("§6Miners Speed!",
                new HashMap<>(){
                    {
                        put(Enchantment.DIG_SPEED, 10);
                    }
                }));

        addRewards(64 * 64, ItemUtil.newItem(Material.LAPIS_BLOCK,
                "§1Conjures Apprentice Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " lapis ore.",
                "Item frame trophy!")
        );
    }
}