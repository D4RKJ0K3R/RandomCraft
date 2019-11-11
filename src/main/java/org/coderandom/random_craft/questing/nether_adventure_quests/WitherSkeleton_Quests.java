package org.coderandom.random_craft.questing.nether_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class WitherSkeleton_Quests extends BaseQuest {
    public WitherSkeleton_Quests() {
        super("wither_skeleton_slaying_quest", "§8Wither Skeleton Quests§6!", "Advanced by slaying wither skeletons!", Statistic.KILL_ENTITY, EntityType.WITHER_SKELETON);
    }
}
