package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerZombiePigman_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerZombiePigman_Enchantment() {
        super(EntityType.PIG_ZOMBIE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Zombie Pigman Spawner";
    }
}
