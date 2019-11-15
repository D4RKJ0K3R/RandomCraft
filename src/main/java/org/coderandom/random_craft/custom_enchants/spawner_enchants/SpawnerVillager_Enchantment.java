package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerVillager_Enchantment extends SpawnerWrapper {
    public SpawnerVillager_Enchantment() {
        super(EntityType.VILLAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Villager Spawner";
    }
}
