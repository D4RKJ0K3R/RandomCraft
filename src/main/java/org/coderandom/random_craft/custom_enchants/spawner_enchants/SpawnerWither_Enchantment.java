package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerWither_Enchantment extends SpawnerWrapper {
    public SpawnerWither_Enchantment() {
        super(EntityType.WITHER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wither Spawner";
    }
}
