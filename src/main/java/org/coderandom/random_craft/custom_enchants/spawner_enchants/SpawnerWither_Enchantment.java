package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerWither_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerWither_Enchantment() {
        super(EntityType.WITHER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wither Spawner";
    }
}
