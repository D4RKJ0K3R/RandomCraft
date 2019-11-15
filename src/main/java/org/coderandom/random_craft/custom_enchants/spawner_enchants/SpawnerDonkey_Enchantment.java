package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerDonkey_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerDonkey_Enchantment() {
        super(EntityType.DONKEY);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Donkey Spawner";
    }
}
