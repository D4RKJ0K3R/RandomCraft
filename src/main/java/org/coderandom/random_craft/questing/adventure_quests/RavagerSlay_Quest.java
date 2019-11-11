package org.coderandom.random_craft.questing.adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class RavagerSlay_Quest extends BaseQuest {
    public RavagerSlay_Quest() {
        super("ravager_slaying_quest", "§7Ravager Slaying Quests§6!", "Advanced by slaying ravagers!", Statistic.KILL_ENTITY, EntityType.RAVAGER);
    }
}