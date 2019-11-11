package org.coderandom.random_craft.questing.end_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Endermite_Quests extends BaseQuest {
    public Endermite_Quests() {
        super("endermite_slaying_quests", "§5Endermite Slaying Quests§6!", "Advanced by slaying endermites", Statistic.KILL_ENTITY, EntityType.ENDERMITE);
    }
}
