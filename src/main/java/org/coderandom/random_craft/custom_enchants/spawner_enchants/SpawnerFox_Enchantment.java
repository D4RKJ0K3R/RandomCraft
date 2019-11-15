package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerFox_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerFox_Enchantment() {
        super(EntityType.FOX);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Fox Spawner";
    }
}
