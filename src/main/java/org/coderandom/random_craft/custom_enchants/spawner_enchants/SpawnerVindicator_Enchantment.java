package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerVindicator_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerVindicator_Enchantment() {
        super(EntityType.VINDICATOR);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Vindicator Spawner";
    }
}
