package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerParrot_Enchantment extends SpawnerWrapper {
    public SpawnerParrot_Enchantment() {
        super(EntityType.PARROT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Parrot Spawner";
    }
}
