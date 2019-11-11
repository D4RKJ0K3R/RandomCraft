package org.coderandom.random_craft.questing;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.questing.adventure_quests.*;
import org.coderandom.random_craft.questing.commands.QuestCommand;
import org.coderandom.random_craft.questing.commands.QuestsCommand;
import org.coderandom.random_craft.questing.craftting_quests.Beacon_Quests;
import org.coderandom.random_craft.questing.end_adventure_quests.*;
import org.coderandom.random_craft.questing.hunting_quests.*;
import org.coderandom.random_craft.questing.mining_quests.*;
import org.coderandom.random_craft.questing.nether_adventure_quests.*;
import org.coderandom.random_craft.questing.slaying_quests.*;
import org.coderandom.random_craft.utils.UIUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class QuestManager implements Listener {
    private static CatagoryManager adventureQuests;
    private static CatagoryManager netherAdventureQuests;
    private static CatagoryManager endAdventureQuests;
    private static CatagoryManager miningQuests;
    private static CatagoryManager craftingQuests;
    private static CatagoryManager huntingQuests;
    private static CatagoryManager slayingQuests;

    public static List<String> listQuests() {
        return new ArrayList<>() {
            {
                adventureQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                netherAdventureQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                endAdventureQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                miningQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                craftingQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                huntingQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
                slayingQuests.getQuests().forEach(baseQuest -> add(baseQuest.getId()));
            }
        };
    }

    public static BaseQuest getQuestByID(String id) {
        AtomicReference<BaseQuest> quest = new AtomicReference<>();

        adventureQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        netherAdventureQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        endAdventureQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        miningQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        craftingQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        huntingQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        slayingQuests.getQuests().forEach(baseQuest -> {
            if (baseQuest.getId().equals(id)) {
                quest.set(baseQuest);
            }
        });

        assert false;
        return quest.get();
    }

    public QuestManager() {
        adventureQuests = new CatagoryManager("Adventure Quests",
                new VillagerTrade_Quests(),
                new Fishing_Quests(),
                new RaidWin_Quests(),
                new PillagerSlay_Quest(),
                new VindicatorSlay_Quest(),
                new RavagerSlay_Quest()
        );
        netherAdventureQuests = new CatagoryManager("Nether Adventure Quests",
                new Netherrack_Quests(),
                new QuartzOre_Quests(),
                new GlowStone_Quests(),
                new Blaze_Quests(),
                new MagmaCube_Quests(),
                new Ghast_Quests(),
                new WitherSkeleton_Quests()
        );
        endAdventureQuests = new CatagoryManager("End Adventure Quests",
                new Endstone_Quests(),
                new Enderman_Quests(),
                new ShulkerSlay_Quests(),
                new EndRod_Quests(),
                new Endermite_Quests(),
                new Dragon_Quests()
        );
        miningQuests = new CatagoryManager("Mining Quests",
                new Stone_Quests(),
                new CoalOre_Quests(),
                new IronOre_Quests(),
                new GoldOre_Quests(),
                new RedStoneOre_Quests(),
                new LapisOre_Quests(),
                new DiamondOre_Quests(),
                new EmeraldOre_Quests(),
                new WetSponge_Quests()
        );
        craftingQuests = new CatagoryManager("Crafting Quests",
                new Beacon_Quests()
        );
        huntingQuests = new CatagoryManager("Hunting Quests",
                new Chicken_Quests(),
                new Cow_Quests(),
                new Pig_Quests(),
                new Sheep_Quests(),
                new Bat_Quests(),
                new Squid_Quests(),
                new Rabbit_Quests(),
                new Wolf_Quests(),
                new Mooshroom_Quests()
        );
        slayingQuests = new CatagoryManager("Slaying Quests",
                new Zombie_Quests(),
                new Creeper_Quests(),
                new Drowned_Quests(),
                new Husk_Quests(),
                new ZombieVillager_Quests(),
                new Skeleton_Quests(),
                new Stray_Quests(),
                new Spider_Quests(),
                new CaveSpider_Quests(),
                new Slime_Quests(),
                new Guardian_Quests(),
                new ElderGuardian_Quests()
        );
        RandomCraft.add(this);
        new QuestsCommand();
        new QuestCommand();
    }

    public static void openUI(Player player) {
        UIUtil ui = new UIUtil("§1Quests§6!", 6);
        ui.addButton(0, RandomCraft.getNms().getSkull("1adbcf23e726f199339b253a5214f8831d62b97a50b0ed932c531f62c3223", adventureQuests.getName()));

        ui.addButton(1, RandomCraft.getNms().getSkull("d83571ff589f1a59bb02b80800fc736116e27c3dcf9efebede8cf1fdde", netherAdventureQuests.getName()));

        ui.addButton(2, RandomCraft.getNms().getSkull("c6cac59b2aae489aa0687b5d802b2555eb14a40bd62b21eb116fa569cdb756", endAdventureQuests.getName()));

        ui.addButton(3, new ItemStack(Material.GOLD_ORE){
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(miningQuests.getName());

                setItemMeta(meta);
            }
        });
        ui.addButton(4, new ItemStack(Material.CRAFTING_TABLE){
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(craftingQuests.getName());

                setItemMeta(meta);
            }
        });
        ui.addButton(5, new ItemStack(Material.BOW){
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(huntingQuests.getName());

                setItemMeta(meta);
            }
        });
        ui.addButton(6, new ItemStack(Material.SKELETON_SKULL){
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName(slayingQuests.getName());

                setItemMeta(meta);
            }
        });

        ui.addButton(49, new ItemStack(Material.BARRIER) {
            {
                ItemMeta meta = getItemMeta();
                meta.setDisplayName("§4Close§6!");
                setItemMeta(meta);
            }
        });
        ui.openUI(player);
    }

    @EventHandler
    public void clickEvent(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("§1Quests§6!")) {
            if (event.getRawSlot() == 0) {
                adventureQuests.openUI((Player) event.getWhoClicked());
            }  else if (event.getRawSlot() == 1) {
                netherAdventureQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 2) {
                endAdventureQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 3) {
                miningQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 4) {
                craftingQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 5) {
                huntingQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 6) {
                slayingQuests.openUI((Player) event.getWhoClicked());
            } else if (event.getRawSlot() == 49) {
                event.getWhoClicked().closeInventory();
            }
        }
    }

    public static CatagoryManager getAdventureQuests() {
        return adventureQuests;
    }

    public static CatagoryManager getMiningQuests() {
        return miningQuests;
    }

    public static CatagoryManager getCraftingQuests() {
        return craftingQuests;
    }

    public static CatagoryManager getHuntingQuests() {
        return huntingQuests;
    }

    public static CatagoryManager getSlayingQuests() {
        return slayingQuests;
    }
}
