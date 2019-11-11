package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Guardian_Quests extends BaseQuest {
    public Guardian_Quests() {
        super("guardian_slaying_quest", "§3Guardian Quests§6!", "Advanced by slaying guardians!", Statistic.KILL_ENTITY, EntityType.GUARDIAN);
    }
}
