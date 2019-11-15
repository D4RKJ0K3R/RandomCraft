package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerWitherSkeleton_Enchantment extends SpawnerWrapper {
    public SpawnerWitherSkeleton_Enchantment() {
        super(EntityType.WITHER_SKELETON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wither Skeleton Spawner";
    }
}
