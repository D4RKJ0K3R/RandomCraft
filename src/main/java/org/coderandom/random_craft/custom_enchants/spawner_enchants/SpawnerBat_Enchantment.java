package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerBat_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerBat_Enchantment() {
        super(EntityType.BAT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Bat Spawner";
    }
}
