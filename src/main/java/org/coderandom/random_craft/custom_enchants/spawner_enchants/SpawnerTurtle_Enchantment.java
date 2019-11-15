package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerTurtle_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerTurtle_Enchantment() {
        super(EntityType.TURTLE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Turtle Spawner";
    }
}
