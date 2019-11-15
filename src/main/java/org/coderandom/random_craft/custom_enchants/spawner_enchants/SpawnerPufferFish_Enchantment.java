package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerPufferFish_Enchantment extends SpawnerWrapper {
    public SpawnerPufferFish_Enchantment() {
        super(EntityType.PUFFERFISH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Puffer Fish Spawner";
    }
}
