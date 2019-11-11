package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class ElderGuardian_Quests extends BaseQuest {
    public ElderGuardian_Quests() {
        super("elder_guardian_slaying_quest", "§bElder Guardian Quests§6!", "Advanced by slaying elder guardians!", Statistic.KILL_ENTITY, EntityType.ELDER_GUARDIAN);
    }
}
