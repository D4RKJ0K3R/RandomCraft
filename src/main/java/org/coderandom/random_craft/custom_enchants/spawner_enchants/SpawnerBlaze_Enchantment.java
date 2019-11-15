package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerBlaze_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerBlaze_Enchantment() {
        super(EntityType.BLAZE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Blaze Spawner";
    }
}
