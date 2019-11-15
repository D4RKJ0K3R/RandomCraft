package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSalmon_Enchantment extends SpawnerWrapper {
    public SpawnerSalmon_Enchantment() {
        super(EntityType.SALMON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Salmon Spawner";
    }
}
