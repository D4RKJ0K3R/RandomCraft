package org.coderandom.random_craft.questing;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.skulls.SkullsManager;
import org.coderandom.random_craft.utils.ItemUtil;
import org.coderandom.random_craft.utils.UIUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CatagoryManager implements Listener {
    private String name;
    private List<BaseQuest> quests;

    public CatagoryManager(String name, BaseQuest... quests) {
        this.name = "§1" + name + "§6!";
        this.quests = Arrays.asList(quests);
        RandomCraft.add(this);
    }

    public void openUI(Player player) {
        UIUtil ui = new UIUtil(name, 6) {
            {
                quests.forEach(quest -> {
                    switch (quest.getStatistic()) {
                        case FISH_CAUGHT:
                            ItemStack item;
                            ItemMeta meta;
                            addButton(quests.indexOf(quest), new ItemStack(Material.FISHING_ROD) {
                                {
                                    ItemMeta meta = getItemMeta();
                                    meta.setDisplayName(quest.getDisplayName());
                                    meta.setLore(new ArrayList<>() {
                                        {
                                            add(quest.getDescription());
                                            add("§2Fish Caught§6: §r" + quest.getStat(player));
                                        }
                                    });
                                    setItemMeta(meta);
                                }
                            });
                            break;
                        case RAID_WIN:
                            item = new ItemStack(ItemUtil.raidBanner(null));
                            meta = item.getItemMeta();
                            meta.setDisplayName(quest.getDisplayName());
                            meta.setLore(new ArrayList<>() {
                                {
                                    add(quest.getDescription());
                                    add("§2Raids Won§6: §r" + quest.getStat(player));
                                }
                            });
                            item.setItemMeta(meta);
                            addButton(quests.indexOf(quest), item);
                            break;
                        case TRADED_WITH_VILLAGER:
                            ItemStack skull = SkullsManager.newSkull(quest.getEntityType());
                            meta = skull.getItemMeta();
                            meta.setDisplayName(quest.getDisplayName());
                            meta.setLore(new ArrayList<>() {
                                {
                                    add(quest.getDescription());
                                    add("§2Times traded§6: §r" + quest.getStat(player));
                                }
                            });
                            skull.setItemMeta(meta);

                            addButton(quests.indexOf(quest), skull);
                            break;
                        case KILL_ENTITY:
                            skull = SkullsManager.newSkull(quest.getEntityType());
                            meta = skull.getItemMeta();
                            meta.setDisplayName(quest.getDisplayName());
                            meta.setLore(new ArrayList<>() {
                                {
                                    add(quest.getDescription());
                                    add("§2Slain§6: §r" + quest.getStat(player));
                                }
                            });
                            skull.setItemMeta(meta);

                            addButton(quests.indexOf(quest), skull);
                            break;
                        default:
                            addButton(quests.indexOf(quest), new ItemStack(quest.getMaterial()) {
                                {
                                    ItemMeta meta = getItemMeta();
                                    meta.setDisplayName(quest.getDisplayName());
                                    meta.setLore(new ArrayList<>() {
                                        {
                                            add(quest.getDescription());
                                            add("§2Mined§6: §r" + quest.getStat(player));
                                        }
                                    });

                                    setItemMeta(meta);
                                }
                            });
                            break;
                    }
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

    public String getName() {
        return name;
    }

    public List<BaseQuest> getQuests() {
        return quests;
    }

    @EventHandler
    public void menuListener(InventoryClickEvent event) {
        if (event.getView().getTitle().equals(name)) {
            int slot = event.getRawSlot();

            if (slot < quests.size()) {
                quests.get(slot).openGUI((Player) event.getWhoClicked());
            } else if (slot == 49) {
                QuestManager.openUI((Player) event.getWhoClicked());
            }
        }
    }
}
