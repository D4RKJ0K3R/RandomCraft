package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerCod_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerCod_Enchantment() {
        super(EntityType.COD);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Cod Spawner";
    }
}
