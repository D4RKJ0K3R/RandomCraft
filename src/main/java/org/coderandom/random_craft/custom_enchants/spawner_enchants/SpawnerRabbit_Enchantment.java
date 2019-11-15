package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerRabbit_Enchantment extends SpawnerWrapper {
    public SpawnerRabbit_Enchantment() {
        super(EntityType.RABBIT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Rabbit Spawner";
    }
}
