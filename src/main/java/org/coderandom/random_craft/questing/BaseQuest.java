package org.coderandom.random_craft.questing;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.raid.RaidFinishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.utils.UIUtil;
import org.coderandom.random_craft.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class BaseQuest implements Listener{
    private String id;
    private String displayName;
    private String description;
    private Material material;
    private Statistic statistic;
    private EntityType entityType;
    private final Map<Integer, ItemStack[]> rewards;

    public BaseQuest(String id, String displayName, String description, Statistic statistic, EntityType entityType) {
        this(id, displayName, description, statistic, null, entityType, new HashMap<>());
    }

    public BaseQuest(String id, String displayName, String description, Material material, Statistic statistic) {
        this(id, displayName, description, statistic, material, null, new HashMap<>());
    }

    private BaseQuest(String id, String displayName, String description, Statistic statistic, Material material, EntityType entityType, Map<Integer, ItemStack[]> rewards) {
        this.id = id;
        this.displayName = displayName;
        this.description = description;
        this.material = material;
        this.rewards = rewards;
        this.statistic = statistic;
        this.entityType = entityType;


        switch (statistic) {
            case FISH_CAUGHT:
                RandomCraft.add(new FishCaughtEvent());
                break;
            case RAID_WIN:
                RandomCraft.add(new RaidWinEvent());
                break;
            case TRADED_WITH_VILLAGER:
                RandomCraft.add(new VillagerTradeEvent());
                break;
            case CRAFT_ITEM:
                RandomCraft.add(new CraftEvent());
                break;
            case MINE_BLOCK:
                RandomCraft.add(new MineEvent());
                break;
            case PLAYER_KILLS:
            case MOB_KILLS:
                RandomCraft.add(new DeathEvent());
                break;
        }

        RandomCraft.add(this);
    }

    public int getStat(Player player) {
        switch (statistic) {
            case RAID_WIN:
                return player.getStatistic(Statistic.RAID_WIN);
            case FISH_CAUGHT:
                return player.getStatistic(Statistic.FISH_CAUGHT);
            case TRADED_WITH_VILLAGER:
                return player.getStatistic(Statistic.TRADED_WITH_VILLAGER);
            case CRAFT_ITEM:
                return player.getStatistic(Statistic.CRAFT_ITEM, material);
            case MINE_BLOCK:
                return player.getStatistic(Statistic.MINE_BLOCK, material);
            case KILL_ENTITY:
                return player.getStatistic(Statistic.KILL_ENTITY, entityType);
            case PLAYER_KILLS:
                return player.getStatistic(Statistic.PLAYER_KILLS);
            default:
                return -1;
        }
    }

    public void openGUI(Player player) {
        UIUtil ui = new UIUtil(displayName, 6) {
            {
                AtomicInteger counter = new AtomicInteger();
                rewards.forEach((statAmount, itemStacks) -> {
                    ItemStack item;
                    ItemMeta meta;

                    if (getStat(player) >= statAmount) {
                        item = new ItemStack(Material.GREEN_BANNER);
                        meta = item.getItemMeta();

                        meta.setDisplayName(statAmount + " §2 COMPLETED§6!");
                    } else {
                        item = new ItemStack(Material.RED_BANNER);
                        meta = item.getItemMeta();

                        meta.setDisplayName(getStat(player) + "§6/§r" + statAmount + " §2 completed§6!");
                    }
                    item.setItemMeta(meta);
                    addButton(counter.get(), item);
                    counter.getAndIncrement();
                });

                addButton(49, new ItemStack(Material.TOTEM_OF_UNDYING) {
                    {
                        ItemMeta meta = getItemMeta();
                        meta.setDisplayName("§2Go Back§6!");
                        setItemMeta(meta);
                    }
                });
            }
        };
        ui.openUI(player);
    }

    protected void addRewards(int statAmount, ItemStack... items) {
        rewards.put(statAmount, items);
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getDescription() {
        return description;
    }

    public Material getMaterial() {
        return material;
    }

    public Statistic getStatistic() {
        return statistic;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public String getId() {
        return id;
    }

    public Map<Integer, ItemStack[]> getRewards() {
        return rewards;
    }

    @EventHandler
    public void menuListener(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(displayName)) {
            int slot = event.getRawSlot();

            if (slot < rewards.size()) {
                List<Integer> statAmount = new ArrayList<>();
                List<ItemStack[]> rewardsList = new ArrayList<>(){
                    {
                        rewards.forEach((integer, itemStacks) -> {
                            add(itemStacks);
                            statAmount.add(integer);
                        });
                    }
                };

                UIUtil ui = new UIUtil("§6Rewards§2!", 1){
                    {
                        ItemStack[] items = rewardsList.get(slot);

                        for (int i = 0; i < items.length; i++) {
                            addButton(i, items[i]);
                        }

                        addButton(8, new ItemStack(Material.TOTEM_OF_UNDYING) {
                            {
                                ItemMeta meta = getItemMeta();
                                meta.setDisplayName("§2Go Back§6!");
                                setItemMeta(meta);
                            }
                        });
                    }
                };
                ui.openUI((Player) event.getWhoClicked());
            }

            if (slot == 49) {
                QuestManager.openUI((Player) event.getWhoClicked());
            }
        } else if (event.getView().getTitle().equals("§6Rewards§2!")){
            if (event.getRawSlot() == 8) {
                QuestManager.openUI((Player) event.getWhoClicked());
            }
        }
    }

    private class CraftEvent implements Listener {
        @EventHandler
        public void event(CraftItemEvent event) {
            Player player = (Player) event.getWhoClicked();

            if (event.getRecipe().getResult().getType().equals(material)) {
                int crafted = getStat(player) + 1;

                if (rewards.containsKey(crafted)) {
                    giveRewards(player, crafted);
                }
            }
        }
    }

    private class MineEvent implements Listener {
        @EventHandler
        public void event(BlockBreakEvent event) {
            Player player = event.getPlayer();
            if (event.getBlock().getType().equals(material)) {
                int harvested = getStat(player) + 1;

                if (rewards.containsKey(harvested)) {
                    giveRewards(player, harvested);
                }
            }
        }
    }

    private class DeathEvent implements Listener{
        @EventHandler
        public void event(EntityDeathEvent event) {
            Player player = event.getEntity().getKiller();

            if (player != null && event.getEntity().getType().equals(entityType)) {
                int slayed = getStat(player);

                if (rewards.containsKey(slayed)) {
                    giveRewards(player, slayed);
                }
            }
        }
    }

    private class VillagerTradeEvent implements Listener {
        @EventHandler
        public void tradeEvent(InventoryClickEvent event) {
            Player player = (Player) event.getWhoClicked();
            if (event.getInventory().getType().equals(InventoryType.MERCHANT)) {
                if (event.getSlot() == 2 && !event.getCurrentItem().getType().equals(Material.AIR)){
                    int stat = player.getStatistic(Statistic.TRADED_WITH_VILLAGER) + 1;

                    if (rewards.containsKey(stat)) {
                        giveRewards(player, stat);
                    }
                }
            }
        }
    }

    private class RaidWinEvent implements Listener {
        @EventHandler
        public void event(RaidFinishEvent event) {
            List<Player> winners = event.getWinners();

            winners.forEach(player -> {
                int stat = getStat(player);

                if (rewards.containsKey(stat)) {
                    giveRewards(player, stat);
                }
            });
        }
    }

    private class FishCaughtEvent implements Listener {
        @EventHandler
        public void event(PlayerFishEvent event) {
            if (event.getCaught() != null) {
                Player player = event.getPlayer();
                int stat = getStat(player);

                if (rewards.containsKey(stat)) {
                    giveRewards(player, stat);
                }
            }
        }
    }

    private void giveRewards(Player player, int amount) {
        ItemStack[] rewardList = rewards.get(amount);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);

        for (ItemStack item : rewardList) {

            if (Utils.emptySlots(player) > 0) {
                player.getInventory().addItem(item);
            } else {
                player.sendMessage("§4Inventory full §6reward §4dropped on floor§6!");
                player.getWorld().dropItemNaturally(player.getLocation(), item);
            }
            String itemName;
            int itemAmount = item.getAmount();
            if (item.getItemMeta() != null && !item.getItemMeta().getDisplayName().equals("")) {
                itemName = item.getItemMeta().getDisplayName();
            } else {
                itemName = Utils.format(item.getType().getKey());
            }

            if (itemAmount > 1) {
                itemName += "§6'§rs";
            }

            String message = player.getDisplayName() + "§2 rewarded §r" + itemAmount + " " + itemName;
            switch (statistic) {
                case RAID_WIN:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for winning §r" + amount + "§2 raids§6!");
                    break;
                case TRADED_WITH_VILLAGER:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for trading §r" + amount + "§2 times with villagers§6!");
                    break;
                case CRAFT_ITEM:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for crafting §r" + amount + " " + Utils.format(material.getKey()) + "§6!");
                    break;
                case MINE_BLOCK:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for harvesting §r" + amount + " " + Utils.format(material.getKey()) + "§6!");
                    break;
                case KILL_ENTITY:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for hunting §r" + amount + " " + Utils.format(entityType.getKey()) + "§6'§rs §6!");
                    break;
                case PLAYER_KILLS:
                    Bukkit.getServer().broadcastMessage(message + "\n§2for slaying §r" + amount + " PLAYERS§6'§rs §6!");
                    break;
                default:
                    player.sendMessage("§4ERROR§6!");
                    break;
            }
        }

    }
}