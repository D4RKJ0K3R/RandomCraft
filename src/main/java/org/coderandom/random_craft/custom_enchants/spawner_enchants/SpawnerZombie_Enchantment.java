package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerZombie_Enchantment extends SpawnerWrapper {
    public SpawnerZombie_Enchantment() {
        super(EntityType.ZOMBIE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Zombie Spawner";
    }
}
