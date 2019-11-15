package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerEvoker_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerEvoker_Enchantment() {
        super(EntityType.EVOKER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Evoker Spawner";
    }
}
