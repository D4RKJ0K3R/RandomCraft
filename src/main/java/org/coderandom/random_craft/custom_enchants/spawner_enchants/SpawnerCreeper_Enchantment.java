package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerCreeper_Enchantment extends SpawnerWrapper {
    public SpawnerCreeper_Enchantment() {
        super(EntityType.CREEPER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Creeper Spawner";
    }
}
