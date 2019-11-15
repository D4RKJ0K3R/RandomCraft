package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerTropicalFish_Enchantment extends SpawnerWrapper {
    public SpawnerTropicalFish_Enchantment() {
        super(EntityType.TROPICAL_FISH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Tropical Fish Spawner";
    }
}
