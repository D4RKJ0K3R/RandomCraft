package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerLightning_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerLightning_Enchantment() {
        super(EntityType.LIGHTNING);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Lightning Spawner";
    }
}
