package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerStray_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerStray_Enchantment() {
        super(EntityType.STRAY);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Stray Spawner";
    }
}
