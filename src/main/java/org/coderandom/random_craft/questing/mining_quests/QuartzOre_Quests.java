package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class QuartzOre_Quests extends BaseQuest {
    public QuartzOre_Quests() {
        super("nether_quartz_ore_quests", "Nether Quartz Quests§6!", "Advanced by mining nether quartz ore", Material.NETHER_QUARTZ_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64,
                new ItemStack(Material.NETHER_QUARTZ_ORE, 64),
                new ItemStack(Material.NETHER_QUARTZ_ORE, 64)
        );

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64, ItemUtil.customPotion(Material.LINGERING_POTION, 4, "§6Extinguish", Color.ORANGE,
                new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8 * 60 * 20, 3)
        ));

        addRewards(32 * 64, ItemUtil.newItem(Material.QUARTZ,
                "§4Nether Adventure Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " nether quartz ore.",
                "Item frame trophy!")
        );

        addRewards(48 * 64, ItemUtil.customEnchantBook("§6Fire Proof Scroll!",
                new HashMap<>(){
                    {
                        put(Enchantment.PROTECTION_FIRE, 10);
                    }
                }));

        addRewards(64 * 64, ItemUtil.newItem(Material.QUARTZ_BLOCK,
                "§4Nether Complete Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " nether quartz ore.",
                "Item frame trophy!")
        );
    }
}
