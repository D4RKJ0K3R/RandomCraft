package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerCow_Enchantment extends SpawnerWrapper {
    public SpawnerCow_Enchantment() {
        super(EntityType.COW);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Cow Spawner";
    }
}
