package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class RedStoneOre_Quests extends BaseQuest {

    public RedStoneOre_Quests() {
        super("redstone_ore_quests", "§cRedstone Quests§6!", "Advanced by mining redstone ore.", Material.REDSTONE_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.customPotion(Material.POTION, 8, "§6Assassins Speed", Color.ORANGE,
                new PotionEffect(PotionEffectType.SPEED, 8 * 60 * 20, 2),
                new PotionEffect(PotionEffectType.FAST_DIGGING, 8 * 60 * 20, 3)
        ));

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64, ItemUtil.customPotion(Material.POTION, 8, "§6Concentrated Assassins Speed", Color.ORANGE,
                new PotionEffect(PotionEffectType.SPEED, 8 * 60 * 20, 3),
                new PotionEffect(PotionEffectType.FAST_DIGGING, 8 * 60 * 20, 6)
        ));

        addRewards(32 * 64, ItemUtil.newItem(Material.REDSTONE,
                "§4Redstoner Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " redstone ore.",
                "Item frame trophy!")
        );

        addRewards(48 * 64, ItemUtil.customPotion(Material.POTION, 8, "§6Ancient Assassins Speed", Color.ORANGE,
                new PotionEffect(PotionEffectType.SPEED, 8 * 60 * 20, 4),
                new PotionEffect(PotionEffectType.FAST_DIGGING, 8 * 60 * 20, 10)
        ));

        addRewards(64 * 64, ItemUtil.newItem(Material.REDSTONE_BLOCK,
                "§4Circuitry Overdrive Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " redstone ore.",
                "Item frame trophy!")
        );
    }
}