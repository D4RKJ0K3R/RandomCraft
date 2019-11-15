package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerWanderingTrader_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerWanderingTrader_Enchantment() {
        super(EntityType.WANDERING_TRADER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Wandering Trader Spawner";
    }
}
