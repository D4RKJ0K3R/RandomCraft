package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerVex_Enchantment extends SpawnerWrapper {
    public SpawnerVex_Enchantment() {
        super(EntityType.VEX);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Vex Spawner";
    }
}
