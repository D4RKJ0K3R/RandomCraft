package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerChicken_Enchantment extends SpawnerWrapper {
    public SpawnerChicken_Enchantment() {
        super(EntityType.CHICKEN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Chicken Spawner";
    }
}
