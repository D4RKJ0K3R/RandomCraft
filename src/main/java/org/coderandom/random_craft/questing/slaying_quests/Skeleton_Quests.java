package org.coderandom.random_craft.questing.slaying_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Skeleton_Quests extends BaseQuest {
    public Skeleton_Quests() {
        super("skeleton_slaying_quest", "§rSkeleton Quests§6!", "Advanced by slaying skeletons!", Statistic.KILL_ENTITY, EntityType.SKELETON);
    }
}
