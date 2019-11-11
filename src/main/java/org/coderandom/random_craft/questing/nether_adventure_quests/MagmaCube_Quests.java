package org.coderandom.random_craft.questing.nether_adventure_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class MagmaCube_Quests extends BaseQuest {
    public MagmaCube_Quests() {
        super("magma_cube_slaying_quest", "§6Magma Cube Quests§6!", "Advanced by slaying magma cubes!", Statistic.KILL_ENTITY, EntityType.MAGMA_CUBE);
    }
}
