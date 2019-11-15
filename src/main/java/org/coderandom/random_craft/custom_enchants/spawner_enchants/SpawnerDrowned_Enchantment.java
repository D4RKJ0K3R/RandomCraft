package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerDrowned_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerDrowned_Enchantment() {
        super(EntityType.DROWNED);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Drowned Spawner";
    }
}
