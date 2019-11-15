package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSalmon_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSalmon_Enchantment() {
        super(EntityType.SALMON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Salmon Spawner";
    }
}
