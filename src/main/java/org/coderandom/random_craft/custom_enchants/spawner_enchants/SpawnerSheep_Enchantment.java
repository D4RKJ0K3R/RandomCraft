package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSheep_Enchantment extends SpawnerWrapper {
    public SpawnerSheep_Enchantment() {
        super(EntityType.SHEEP);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Sheep Spawner";
    }
}
