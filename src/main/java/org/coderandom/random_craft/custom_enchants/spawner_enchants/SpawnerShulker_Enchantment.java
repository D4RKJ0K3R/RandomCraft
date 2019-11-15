package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerShulker_Enchantment extends SpawnerWrapper {
    public SpawnerShulker_Enchantment() {
        super(EntityType.SHULKER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Shulker Spawner";
    }
}
