package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerMagmaCube_Enchantment extends SpawnerWrapper {
    public SpawnerMagmaCube_Enchantment() {
        super(EntityType.MAGMA_CUBE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Magma Cube Spawner";
    }
}
