package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerHorse_Enchantment extends SpawnerWrapper {
    public SpawnerHorse_Enchantment() {
        super(EntityType.HORSE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Horse Spawner";
    }
}
