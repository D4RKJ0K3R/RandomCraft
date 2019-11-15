package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerPillager_Enchantment extends SpawnerWrapper {
    public SpawnerPillager_Enchantment() {
        super(EntityType.PILLAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Pillager Spawner";
    }
}
