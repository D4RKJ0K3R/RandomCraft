package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerTropicalFish_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerTropicalFish_Enchantment() {
        super(EntityType.TROPICAL_FISH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Tropical Fish Spawner";
    }
}
