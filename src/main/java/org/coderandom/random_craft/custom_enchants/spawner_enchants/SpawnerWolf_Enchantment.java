package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerWolf_Enchantment extends SpawnerWrapper {
    public SpawnerWolf_Enchantment() {
        super(EntityType.WOLF);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wolf Spawner";
    }
}
