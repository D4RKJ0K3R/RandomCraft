package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerVex_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerVex_Enchantment() {
        super(EntityType.VEX);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Vex Spawner";
    }
}
