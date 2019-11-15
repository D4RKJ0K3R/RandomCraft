package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerCow_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerCow_Enchantment() {
        super(EntityType.COW);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Cow Spawner";
    }
}
