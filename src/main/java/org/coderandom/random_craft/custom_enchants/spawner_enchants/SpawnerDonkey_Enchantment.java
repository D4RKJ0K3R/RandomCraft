package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerDonkey_Enchantment extends SpawnerWrapper {
    public SpawnerDonkey_Enchantment() {
        super(EntityType.DONKEY);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Donkey Spawner";
    }
}
