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

public class CoalOre_Quests extends BaseQuest {
    public CoalOre_Quests() {
        super("coal_ore_quests", "§8Coal Quests§6!", "Advanced by mining coal ore.", Material.COAL_ORE, Statistic.MINE_BLOCK);

        addRewards( 3 * 64,
                new ItemStack(Material.COAL_BLOCK, 4)
        );

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16)
        );

        addRewards(16 * 64,
                ItemUtil.customPotion( Material.LINGERING_POTION,
                        4,
                        "§6Miners",
                        Color.ORANGE,
                        new PotionEffect(PotionEffectType.FAST_DIGGING, 6 * 60 * 20, 1)
                )
        );

        addRewards(32 * 64, ItemUtil.newItem(Material.COAL,
                "§8Suety Diamond Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " coal.",
                "Item frame trophy!")
        );

        addRewards(64 * 64, ItemUtil.newItem(Material.COAL_BLOCK,
                "§cHOT STUFF Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " coal.",
                "Item frame trophy!")
        );
    }
}
