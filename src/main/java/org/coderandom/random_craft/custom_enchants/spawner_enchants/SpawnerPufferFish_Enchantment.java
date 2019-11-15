package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPufferFish_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPufferFish_Enchantment() {
        super(EntityType.PUFFERFISH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Puffer Fish Spawner";
    }
}
