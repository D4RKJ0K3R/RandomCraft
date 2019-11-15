package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPillager_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPillager_Enchantment() {
        super(EntityType.PILLAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Pillager Spawner";
    }
}
