package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class WetSponge_Quests extends BaseQuest {
    public WetSponge_Quests() {
        super("wet_sponge_quests", "§eSponge Quests§6!", "Advanced by mining sponge from under water temples.", Material.WET_SPONGE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.customEnchantBook("§9Water Breathing Scroll§6!", new HashMap<>(){
            {
                put(Enchantment.WATER_WORKER, 9999);
            }
        }));

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64, ItemUtil.newItem(Material.GUARDIAN_SPAWN_EGG, "§4Guardian Egg§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                }, "It's close to hatching..."));

        addRewards(32 * 64, ItemUtil.newItem(Material.WET_SPONGE,
                "§eWet Times Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from harvesting " + 32 * 64 + " wet sponge.",
                "Item frame trophy!")
        );

        addRewards(48 * 64, ItemUtil.newItem(Material.ELDER_GUARDIAN_SPAWN_EGG, "§4Elder Guardian Egg§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                }, "How do you think it fits in there..."));

        addRewards(64 * 64, ItemUtil.newItem(Material.SPONGE,
                "§eDiving Expert Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from harvesting " + 64 * 64 + " wet sponge.",
                "Item frame trophy!")
        );
    }
}
