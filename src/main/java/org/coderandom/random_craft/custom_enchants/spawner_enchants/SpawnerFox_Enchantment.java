package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerFox_Enchantment extends SpawnerWrapper {
    public SpawnerFox_Enchantment() {
        super(EntityType.FOX);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Fox Spawner";
    }
}
