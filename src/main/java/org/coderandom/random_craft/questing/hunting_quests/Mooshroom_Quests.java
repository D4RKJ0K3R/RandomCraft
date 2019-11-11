package org.coderandom.random_craft.questing.hunting_quests;

import org.bukkit.Statistic;
import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.questing.BaseQuest;

public class Mooshroom_Quests extends BaseQuest {
    public Mooshroom_Quests() {
        super("mooshroom_quests", "§rM§4o§ro§4s§rh§4r§rr§4o§ro§4m§r Quests§6!", "Advanced by hunting mooshrooms.", Statistic.KILL_ENTITY, EntityType.MUSHROOM_COW);
    }
}
