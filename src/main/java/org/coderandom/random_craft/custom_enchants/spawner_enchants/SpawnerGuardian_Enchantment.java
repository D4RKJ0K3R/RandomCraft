package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerGuardian_Enchantment extends SpawnerWrapper {
    public SpawnerGuardian_Enchantment() {
        super(EntityType.GUARDIAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Guardian Spawner";
    }
}
