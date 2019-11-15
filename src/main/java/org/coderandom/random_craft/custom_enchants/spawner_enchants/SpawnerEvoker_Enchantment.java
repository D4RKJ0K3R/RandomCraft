package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerEvoker_Enchantment extends SpawnerWrapper {
    public SpawnerEvoker_Enchantment() {
        super(EntityType.EVOKER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Evoker Spawner";
    }
}
