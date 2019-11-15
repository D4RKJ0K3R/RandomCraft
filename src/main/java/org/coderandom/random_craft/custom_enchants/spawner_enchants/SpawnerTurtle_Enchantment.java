package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerTurtle_Enchantment extends SpawnerWrapper {
    public SpawnerTurtle_Enchantment() {
        super(EntityType.TURTLE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Turtle Spawner";
    }
}
