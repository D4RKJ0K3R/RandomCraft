package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPig_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPig_Enchantment() {
        super(EntityType.PIG);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Pig Spawner";
    }
}
