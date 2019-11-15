package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerWolf_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerWolf_Enchantment() {
        super(EntityType.WOLF);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wolf Spawner";
    }
}
