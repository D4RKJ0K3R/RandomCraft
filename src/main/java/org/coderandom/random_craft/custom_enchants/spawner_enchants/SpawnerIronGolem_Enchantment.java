package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerIronGolem_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerIronGolem_Enchantment() {
        super(EntityType.IRON_GOLEM);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Iron Golem Spawner";
    }
}
