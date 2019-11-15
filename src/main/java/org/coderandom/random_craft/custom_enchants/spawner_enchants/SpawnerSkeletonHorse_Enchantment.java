package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSkeletonHorse_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSkeletonHorse_Enchantment() {
        super(EntityType.SKELETON_HORSE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Skeleton Horse Spawner";
    }
}
