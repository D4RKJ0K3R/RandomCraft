package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerMule_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerMule_Enchantment() {
        super(EntityType.MULE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Mule Spawner";
    }
}
