package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerPhantom_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerPhantom_Enchantment() {
        super(EntityType.PHANTOM);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Phantom Spawner";
    }
}
