package org.coderandom.random_craft.utils;

import org.bukkit.Color;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.block.banner.Pattern;
import org.bukkit.block.banner.PatternType;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BannerMeta;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;

import java.util.*;

public class ItemUtil {
    public static ItemStack newItem(Material material, String name, boolean unbreakable, Map<Enchantment, Integer> enchantments, String... lore) {
        ItemStack item = new ItemStack(material){
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(name);
                meta.setUnbreakable(unbreakable);
                enchantments.forEach((enchantment, level) -> meta.addEnchant(enchantment, level, true));
                meta.setLore(new ArrayList<>(){
                    {
                        addAll(Arrays.asList(lore));
                        if (meta.getEnchants().size() > 0) {
                            meta.getEnchants().forEach((enchantment, level) -> {
                                add("§2" + Utils.format(enchantment.getKey()) + "§6: §r" + level);
                            });
                        }
                    }
                });
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);

                setItemMeta(meta);
            }
        };

        return item;
    }

    public static ItemStack mendy() {
         return customEnchantBook("§2Mendy the mending book§6!", new HashMap<>(){
            {
                put(Enchantment.MENDING, 1);
            }
        }, "Here for all your mending needs!");
    }

    public static ItemStack raidBanner(String name) {
        return new ItemStack(Material.WHITE_BANNER) {
            {
                BannerMeta meta = (BannerMeta) getItemMeta();
                meta.setDisplayName(Objects.requireNonNullElse(name, "§6§oOminous Banner"));
                meta.setPatterns(new ArrayList<>(){
                    {
                        add(new Pattern(DyeColor.CYAN, PatternType.RHOMBUS_MIDDLE));
                        add(new Pattern(DyeColor.LIGHT_GRAY, PatternType.STRIPE_BOTTOM));
                        add(new Pattern(DyeColor.GRAY, PatternType.STRIPE_CENTER));
                        add(new Pattern(DyeColor.LIGHT_GRAY, PatternType.BORDER));
                        add(new Pattern(DyeColor.BLACK, PatternType.STRIPE_MIDDLE));
                        add(new Pattern(DyeColor.LIGHT_GRAY, PatternType.HALF_HORIZONTAL));
                        add(new Pattern(DyeColor.LIGHT_GRAY, PatternType.CIRCLE_MIDDLE));
                        add(new Pattern(DyeColor.BLACK, PatternType.BORDER));
                    }
                });
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_PLACED_ON);
                setItemMeta(meta);
            }
        };
    }

    public static ItemStack customEnchantBook(String name, HashMap<Enchantment, Integer> enchantments, String... lore) {
        return new ItemStack(Material.ENCHANTED_BOOK) {
            {
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) getItemMeta();
                enchantments.forEach((enchantment, level) -> meta.addStoredEnchant(enchantment, level, true));
                meta.setDisplayName(name);
                meta.setLore(new ArrayList<>(){
                    {
                        addAll(Arrays.asList(lore));
                        if (meta.getEnchants().size() > 0) {
                            if (!(meta.getEnchants().size() == 1) && !meta.getEnchants().containsKey(Enchantment.LUCK)) {
                                add("§2§nEnchantments§6:");
                            }
                        }
                        enchantments.forEach((enchantment, level) -> {
                            if (enchantment.equals(Enchantment.LUCK)) {
                                return;
                            }

                            add("§2" + Utils.format(enchantment.getKey()) + "§6: §r" + level);
                        });
                        add("Hidden knowledge from long ago...");
                    }
                });
                meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_ATTRIBUTES);
                setItemMeta(meta);
            }
        };
    }

    public static ItemStack theGoodStuff(int bottles) {
        return new ItemStack(Material.EXPERIENCE_BOTTLE, bottles) {
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName("§eBottle o' Good Stuff");
                meta.setLore(new ArrayList<>(){
                    {
                        add("I wouldn't drink to much...");
                    }
                });
                setItemMeta(meta);
            }
        };
    }

    public static ItemStack customPotion(Material potionType, int amount, String name, Color color, PotionEffect... effects) {
        Material finalType;
        String finalName;
        switch (potionType) {
            case LINGERING_POTION:
                finalType = Material.LINGERING_POTION;
                finalName = name + " Lingering Potion";
                break;
            case SPLASH_POTION:
                finalType = Material.SPLASH_POTION;
                finalName = name + " Splash Potion";
                break;
            default:
                finalType = Material.POTION;
                finalName = name + " Potion";
                break;
        }
        return new ItemStack(finalType, amount) {
            {
                PotionMeta meta = (PotionMeta) getItemMeta();
                for (int i = 0; i < effects.length; i++) {
                    meta.addCustomEffect(effects[i], true);
                }
                meta.setDisplayName(finalName);
                meta.setColor(color);
                meta.setLore(new ArrayList<>(){
                    {


                        meta.getCustomEffects().forEach(effect -> {
                            int minutes = (effect.getDuration() / 20) / 60;
                            int seconds = (effect.getDuration() / 20) % 60;
                            String duration = "";
                            if (minutes < 10) {
                                duration += "0" + minutes;
                            } else {
                                duration += minutes;
                            }
                            duration += ":";
                            if (seconds == 0) {
                                duration += "00";
                            } else if (seconds < 10) {
                                duration += "0" + seconds;
                            } else {
                                duration += seconds;
                            }

                            add(String.format("§9" + effect.getType().getName().toLowerCase().replace('_', ' ') +
                                    " " + effect.getAmplifier() +
                                    " (" + duration + ")"));
                        });
                    }
                });
                meta.addItemFlags(ItemFlag.HIDE_POTION_EFFECTS);
                setItemMeta(meta);
            }
        };
    }
}
