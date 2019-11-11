package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class PillagerSlay_Quest extends BaseQuest {
    public PillagerSlay_Quest() {
        super("pillager_slaying_quest", "§7Pillager Slaying Quests§6!", "Advanced by slaying pillagers!", Statistic.KILL_ENTITY, EntityType.PILLAGER);
    }
}
