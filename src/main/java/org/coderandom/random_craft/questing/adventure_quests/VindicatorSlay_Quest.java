package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class VindicatorSlay_Quest extends BaseQuest {
    public VindicatorSlay_Quest() {
        super("vindicator_slaying_quest", "§5Vindicator Slaying Quests§6!", "Advanced by slaying vindicators!", Statistic.KILL_ENTITY, EntityType.VINDICATOR);
    }
}
