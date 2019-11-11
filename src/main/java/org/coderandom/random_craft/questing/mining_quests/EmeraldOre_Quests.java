package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class EmeraldOre_Quests extends BaseQuest {
    public EmeraldOre_Quests() {
        super("emerald_ore_quests", "§aEmerald Quests§6!", "Advanced by mining emerald ore.", Material.EMERALD_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.customEnchantBook("§eUnbreaking Scroll§6!", new HashMap<>(){
            {
                put(Enchantment.DURABILITY, 5);
            }
        }));

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(8)
        );

        addRewards(16 * 64, ItemUtil.newItem(Material.VILLAGER_SPAWN_EGG, "§aVillager Egg§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                }, "Don't ask how we got this..."));

        addRewards(32 * 64, ItemUtil.newItem(Material.EMERALD,
                "§aJust Showing Off Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " emerald ore.",
                "Item frame trophy!")
        );

        addRewards(48 * 64, ItemUtil.newItem(Material.VILLAGER_SPAWN_EGG, "§aVillager Egg§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                }, "Don't ask how we got this..."));

        addRewards(64 * 64, ItemUtil.newItem(Material.EMERALD_BLOCK,
                "§aWorld trader Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " emerald ore.",
                "Item frame trophy!")
        );
    }
}
