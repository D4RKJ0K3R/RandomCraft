package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerZombieHorse_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerZombieHorse_Enchantment() {
        super(EntityType.ZOMBIE_HORSE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Zombie Horse Spawner";
    }
}
