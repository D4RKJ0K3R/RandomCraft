package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSkeleton_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSkeleton_Enchantment() {
        super(EntityType.SKELETON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Skeleton Spawner";
    }
}
