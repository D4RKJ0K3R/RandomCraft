package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerMule_Enchantment extends SpawnerWrapper {
    public SpawnerMule_Enchantment() {
        super(EntityType.MULE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Mule Spawner";
    }
}
