package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerCaveSpider_Enchantment extends SpawnerWrapper {
    public SpawnerCaveSpider_Enchantment() {
        super(EntityType.CAVE_SPIDER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Cave Spider Spawner";
    }
}
