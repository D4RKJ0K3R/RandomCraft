package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerZombieVillager_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerZombieVillager_Enchantment() {
        super(EntityType.ZOMBIE_VILLAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Zombie Villager Spawner";
    }
}
