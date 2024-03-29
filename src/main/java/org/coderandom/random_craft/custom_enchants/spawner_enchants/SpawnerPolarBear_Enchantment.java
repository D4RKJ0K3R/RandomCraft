package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPolarBear_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPolarBear_Enchantment() {
        super(EntityType.POLAR_BEAR);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Polar Bear Spawner";
    }
}
