package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerStray_Enchantment extends SpawnerWrapper {
    public SpawnerStray_Enchantment() {
        super(EntityType.STRAY);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Stray Spawner";
    }
}
