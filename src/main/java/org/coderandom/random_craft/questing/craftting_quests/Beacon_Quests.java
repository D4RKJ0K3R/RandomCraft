package org.coderandom.random_craft.questing.craftting_quests;

import org.bukkit.Material;
import org.bukkit.Statistic;
import org.coderandom.random_craft.questing.BaseQuest;

public class Beacon_Quests extends BaseQuest {
    public Beacon_Quests() {
        super("beacon_craft_quests", "§aBeacon Crafting Quests§6!", "Advanced by crafting beacons!", Material.BEACON, Statistic.CRAFT_ITEM);
    }
}
