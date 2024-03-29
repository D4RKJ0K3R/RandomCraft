package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPanda_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPanda_Enchantment() {
        super(EntityType.PANDA);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Panda Spawner";
    }
}
