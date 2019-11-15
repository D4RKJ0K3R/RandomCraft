package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerDrowned_Enchantment extends SpawnerWrapper {
    public SpawnerDrowned_Enchantment() {
        super(EntityType.DROWNED);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Drowned Spawner";
    }
}
