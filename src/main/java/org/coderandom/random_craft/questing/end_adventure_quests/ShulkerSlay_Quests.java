package org.coderandom.random_craft.questing.end_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class ShulkerSlay_Quests extends BaseQuest {
    public ShulkerSlay_Quests() {
        super("shulker_slaying_quests", "§aShulker Slaying Quests§6!", "Advanced by slaying shulkers!", Statistic.KILL_ENTITY, EntityType.SHULKER);
    }
}
