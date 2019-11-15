package org.coderandom.random_craft.custom_enchants;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.custom_enchants.enchantments.*;
import org.coderandom.random_craft.custom_enchants.spawner_enchants.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CustomEnchants implements Listener {
    private static final String[] NUMERALS = {
            "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X",
            "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII","XVIII","XIX","XX",
            "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII","XXVIII","XXIX","XXX",
            "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII","XXXVIII","XXXIX","XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII","XLVIII","XLIX","L",
    };
    public static Enchantment TELEKINESIS = new Telekinesis_Enchantment();
    public static Enchantment STRIKE = new Strike_Enchantment();
    public static Enchantment HOLDING = new Holding_Enchantment();
    public static Enchantment ENDER = new Ender_Enchantment();
    public static Enchantment EXPLOSIVE = new Explosive_Enchantment();
    public static Enchantment INCENDIARY = new Incendiary_Enchantment();
    public static Enchantment NIGHTVISION = new NightVision_Enchantment();
    public static Enchantment DROWNED = new TheDrowned_Enchantment();
    public static Enchantment MINERS_TOUCH = new MinersTouch_Enchantment();
    public static Enchantment SMELT = new Smelt_Enchant();

    public static ArrayList<Enchantment> spawnerEnchants;

    public CustomEnchants() {
        // Spawner Enchantments
        spawnerEnchants = new ArrayList<>() {
            {
                add(new SpawnerBat_Enchantment());
                add(new SpawnerBlaze_Enchantment());
                add(new SpawnerCat_Enchantment());
                add(new SpawnerCaveSpider_Enchantment());
                add(new SpawnerChicken_Enchantment());
                add(new SpawnerCod_Enchantment());
                add(new SpawnerCow_Enchantment());
                add(new SpawnerCreeper_Enchantment());
                add(new SpawnerDolphin_Enchantment());
                add(new SpawnerDonkey_Enchantment());
                add(new SpawnerDrowned_Enchantment());
                add(new SpawnerElderGuardian_Enchantment());
                add(new SpawnerEnderDragon_Enchantment());
                add(new SpawnerEnderman_Enchantment());
                add(new SpawnerEndermite_Enchantment());
                add(new SpawnerEvoker_Enchantment());
                add(new SpawnerFox_Enchantment());
                add(new SpawnerGhast_Enchantment());
                add(new SpawnerGuardian_Enchantment());
                add(new SpawnerHorse_Enchantment());
                add(new SpawnerHusk_Enchantment());
                add(new SpawnerIronGolem_Enchantment());
                add(new SpawnerLightning_Enchantment());
                add(new SpawnerLlama_Enchantment());
                add(new SpawnerMagmaCube_Enchantment());
                add(new SpawnerMooshroom_Enchantment());
                add(new SpawnerMule_Enchantment());
                add(new SpawnerOcelot_Enchantment());
                add(new SpawnerPanda_Enchantment());
                add(new SpawnerParrot_Enchantment());
                add(new SpawnerPhantom_Enchantment());
                add(new SpawnerPig_Enchantment());
                add(new SpawnerPillager_Enchantment());
                add(new SpawnerPolarBear_Enchantment());
                add(new SpawnerPufferFish_Enchantment());
                add(new SpawnerRabbit_Enchantment());
                add(new SpawnerRavager_Enchantment());
                add(new SpawnerSalmon_Enchantment());
                add(new SpawnerSheep_Enchantment());
                add(new SpawnerShulker_Enchantment());
                add(new SpawnerSilverFish_Enchantment());
                add(new SpawnerSkeleton_Enchantment());
                add(new SpawnerSkeletonHorse_Enchantment());
                add(new SpawnerSlime_Enchantment());
                add(new SpawnerSnowGolem_Enchantment());
                add(new SpawnerSpider_Enchantment());
                add(new SpawnerSquid_Enchantment());
                add(new SpawnerStray_Enchantment());
                add(new SpawnerTNT_Enchantment());
                add(new SpawnerTropicalFish_Enchantment());
                add(new SpawnerTurtle_Enchantment());
                add(new SpawnerVex_Enchantment());
                add(new SpawnerVillager_Enchantment());
                add(new SpawnerVindicator_Enchantment());
                add(new SpawnerWanderingTrader_Enchantment());
                add(new SpawnerWitch_Enchantment());
                add(new SpawnerWither_Enchantment());
                add(new SpawnerWitherSkeleton_Enchantment());
                add(new SpawnerWolf_Enchantment());
                add(new SpawnerZombie_Enchantment());
                add(new SpawnerZombieHorse_Enchantment());
                add(new SpawnerZombiePigman_Enchantment());
                add(new SpawnerZombieVillager_Enchantment());
            }
        };

        Bukkit.getPluginManager().registerEvents(this, RandomCraft.getInstance());
        Bukkit.getPluginManager().registerEvents(new CraftListener(), RandomCraft.getInstance());
    }

    public static Enchantment spawnerEnchant(EntityType entityType) {
        AtomicReference<Enchantment> enchant = new AtomicReference<>();

        spawnerEnchants.forEach(enchantment -> {
            if (((CustomWrapper.SpawnerWrapper) enchantment).getEntityType().equals(entityType)) {
                enchant.set(enchantment);
            }
        });

        return enchant.get();
    }

    public static void register(Enchantment enchantment) {
        try {
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public static void unRegister(Enchantment enchantment) {
        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            if(byKey.containsKey(enchantment.getKey())) {
                byKey.remove(enchantment.getKey());
            }
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            if(byName.containsKey(enchantment.getName())) {
                byName.remove(enchantment.getName());
            }
        } catch (Exception ignored) { }
    }

    private static int checkLevel(Enchantment enchantment, int level) {
        if (enchantment.getMaxLevel() == enchantment.getStartLevel()) {
            return enchantment.getStartLevel();
        }

        if (level < enchantment.getStartLevel()) {
            return enchantment.getStartLevel();
        }

        return Math.min(level, enchantment.getMaxLevel());
    }

    public static ItemStack addEnchant(ItemStack item, Enchantment enchantment, int level) {
        if (!enchantment.canEnchantItem(item)) {
            return item;
        }

        if (hasEnchantment(item, enchantment)) {
            if (getLevel(item, enchantment) != level) {
                level = Math.max(getLevel(item, enchantment), level) + 1;
            }
        }
        level = checkLevel(enchantment, level);

        if (item.getType().equals(Material.BOOK)) {
            item.setType(Material.ENCHANTED_BOOK);
        }


        int finalLevel = level;
        return new ItemStack(item) {
            {

                if (item.getType().equals(Material.ENCHANTED_BOOK)) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) removeEnchant(this, enchantment).getItemMeta();
                    if (enchantment instanceof CustomWrapper) {
                        List<String> lore = new ArrayList<>() {
                            {
                                if (meta.getLore() != null) {
                                    addAll(meta.getLore());
                                }

                                add(returnEnchantmentName(enchantment, finalLevel));
                            }
                        };
                        meta.setLore(lore);
                    }
                    meta.addStoredEnchant(enchantment, finalLevel, true);
                    setItemMeta(meta);
                } else {
                    ItemMeta meta = removeEnchant(this, enchantment).getItemMeta();
                    if (enchantment instanceof CustomWrapper) {
                        List<String> lore = new ArrayList<>() {
                            {
                                if (meta.getLore() != null) {
                                    addAll(meta.getLore());
                                }

                                add(returnEnchantmentName(enchantment, finalLevel));
                            }
                        };
                        meta.setLore(lore);
                    }
                    meta.addEnchant(enchantment, finalLevel, true);
                    setItemMeta(meta);
                }
            }
        };
    }

    public static int getTotalLevels(ItemStack itemStack) {
        AtomicInteger levels = new AtomicInteger(0);

            if (itemStack.getType().equals(Material.ENCHANTED_BOOK)) {
                EnchantmentStorageMeta meta = (EnchantmentStorageMeta) itemStack.getItemMeta();
                meta.getStoredEnchants().forEach((enchantment, integer) -> levels.addAndGet(Math.max(1, getLevel(itemStack, enchantment))));
            } else {
                itemStack.getItemMeta().getEnchants().forEach((enchantment, integer) -> levels.addAndGet(Math.max(1, getLevel(itemStack, enchantment))));
            }

        return (levels.get() * itemStack.getAmount());
    }

    public static ItemStack removeAll(ItemStack itemStack) {
        return new ItemStack(itemStack) {
            {
                if (itemStack.getType().equals(Material.ENCHANTED_BOOK)) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) getItemMeta();
                    meta.getStoredEnchants().forEach((enchantment, integer) -> setItemMeta(removeEnchant(this, enchantment).getItemMeta()));
                } else {
                    getItemMeta().getEnchants().forEach((enchantment, integer) -> setItemMeta(removeEnchant(this, enchantment).getItemMeta()));
                }
            }
        };
    }

    public static ItemStack removeEnchant(ItemStack item, Enchantment enchantment) {
        return new ItemStack(item) {
            {
                if (item.getType().equals(Material.ENCHANTED_BOOK)) {
                    EnchantmentStorageMeta meta = (EnchantmentStorageMeta) getItemMeta();
                    if (meta.hasStoredEnchant(enchantment)) {
                        if (enchantment instanceof CustomWrapper) {
                            List<String> lore = new ArrayList<>() {
                                {
                                    if (meta.getLore() != null) {
                                        addAll(meta.getLore());
                                    }
                                    remove(returnEnchantmentName(enchantment, getLevel(item, enchantment)));
                                }
                            };
                            meta.setLore(lore);
                        }
                        meta.removeStoredEnchant(enchantment);
                        setItemMeta(meta);
                    }
                } else {
                    ItemMeta meta = getItemMeta();
                    if (meta.hasEnchant(enchantment)) {
                        if (enchantment instanceof CustomWrapper) {
                            List<String> lore = new ArrayList<>() {
                                {
                                    if (meta.getLore() != null) {
                                        addAll(meta.getLore());
                                    }

                                    remove(returnEnchantmentName(enchantment, getLevel(item, enchantment)));
                                }
                            };
                            meta.setLore(lore);
                        }
                        meta.removeEnchant(enchantment);
                        setItemMeta(meta);
                    }
                }
            }
        };
    }

    public static String returnEnchantmentName(Enchantment enchantment, int level){
        if(level == 1 && enchantment.getMaxLevel() == 1){
            return "§r§7" + enchantment.getName();
        }
        if(level > 50 || level <= 0){
            return "§r§7" + enchantment.getName() + " " + level;
        }

        return "§r§7" + enchantment.getName() + " " + NUMERALS[level- 1];
    }

    public static boolean canUseEnchant(ItemStack item, Enchantment enchantment) {
        Material type = item.getType();
        if (type.equals(Material.ENCHANTED_BOOK) || type.equals(Material.EMERALD)) {
            return false;
        } else {
            if (hasEnchantment(item, enchantment)) {
                return enchantment.canEnchantItem(item);
            }

            return false;
        }
    }

    public static boolean hasMending(Player player) {
        PlayerInventory inventory = player.getInventory();

        if (hasEnchantment(inventory.getItemInMainHand(), Enchantment.MENDING)) {
            return true;
        } else if (hasEnchantment(inventory.getItemInOffHand(), Enchantment.MENDING)) {
            return true;
        } else if (inventory.getHelmet() != null && hasEnchantment(inventory.getHelmet(), Enchantment.MENDING)) {
            return true;
        } else if (inventory.getChestplate() != null && hasEnchantment(inventory.getChestplate(), Enchantment.MENDING)) {
            return true;
        } else if (inventory.getLeggings() != null && hasEnchantment(inventory.getLeggings(), Enchantment.MENDING)) {
            return true;
        } else return inventory.getBoots() != null && hasEnchantment(inventory.getBoots(), Enchantment.MENDING);
    }


    public static boolean hasEnchantment(ItemStack item, Enchantment enchant){
        if (item.getType().equals(Material.ENCHANTED_BOOK)) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();

            if(meta != null) {
                if (meta.getStoredEnchants().size() > 0) {
                    for (Map.Entry<Enchantment, Integer> e : meta.getStoredEnchants().entrySet()) {
                        if (e.getKey().equals(enchant)) {
                            return true;
                        }
                    }
                }
            }
        } else {
            if(item.getItemMeta() != null) {
                item.getItemMeta().getEnchants();
                if (item.getItemMeta().getEnchants().size() > 0) {
                    for (Map.Entry<Enchantment, Integer> e : item.getItemMeta().getEnchants().entrySet()) {
                        if (e.getKey().equals(enchant)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public static int getLevel(ItemStack item, Enchantment enchant){
        if (item.getType().equals(Material.ENCHANTED_BOOK)) {
            EnchantmentStorageMeta meta = (EnchantmentStorageMeta) item.getItemMeta();

            if(meta != null) {

                if (meta.getStoredEnchants().size() > 0) {
                    for (Map.Entry<Enchantment, Integer> e : meta.getStoredEnchants().entrySet()) {
                        if (e.getKey().equals(enchant)) {
                            return e.getValue();
                        }
                    }
                }
            }
        } else {
            if(item.getItemMeta() != null) {
                item.getItemMeta().getEnchants();
                if (item.getItemMeta().getEnchants().size() > 0) {
                    for (Map.Entry<Enchantment, Integer> e : item.getItemMeta().getEnchants().entrySet()) {
                        if (e.getKey().equals(enchant)) {
                            return e.getValue();
                        }
                    }
                }
            }
        }
        return 0;
    }
}
