package org.coderandom.random_craft.questing.mining_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.enchantments.Enchantment;
import org.coderandom.random_craft.questing.BaseQuest;
import org.coderandom.random_craft.utils.ItemUtil;

import java.util.HashMap;

public class IronOre_Quests extends BaseQuest {

    public IronOre_Quests() {
        super("iron_ore_quests", "§fIron Quests§6!", "Advanced by mining iron ore.", Material.IRON_ORE, Statistic.MINE_BLOCK);

        addRewards(2 * 64, ItemUtil.newItem(Material.IRON_PICKAXE,
                "§7R§4u§7s§4t§7y §4T§7h§4e §7H§4a§7r§4d §7W§4o§7r§4k§7i§4n§7g§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.DIG_SPEED, 2);
                        put(Enchantment.LOOT_BONUS_BLOCKS, 2);
                    }
                },
                "Always could get the job done RIP...")
        );

        addRewards(9 * 64,
                ItemUtil.theGoodStuff(16),
                ItemUtil.theGoodStuff(8)
        );

        addRewards(16 * 64,
                ItemUtil.mendy()
        );

        addRewards(32 * 64, ItemUtil.newItem(Material.IRON_INGOT,
                "§7The Founder Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 32 * 64 + " iron ore.",
                "Item frame trophy!")
        );

        addRewards(64 * 64, ItemUtil.newItem(Material.IRON_BLOCK,
                "§7Industrial Age Trophy§6!",
                true,
                new HashMap<>(){
                    {
                        put(Enchantment.LUCK, 1);
                    }
                },
                "Earned from mining " + 64 * 64 + " iron ore.",
                "Item frame trophy!")
        );
    }
}