package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSkeleton_Enchantment extends SpawnerWrapper {
    public SpawnerSkeleton_Enchantment() {
        super(EntityType.SKELETON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Skeleton Spawner";
    }
}