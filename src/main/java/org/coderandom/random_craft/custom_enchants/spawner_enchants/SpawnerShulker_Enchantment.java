package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerShulker_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerShulker_Enchantment() {
        super(EntityType.SHULKER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Shulker Spawner";
    }
}
