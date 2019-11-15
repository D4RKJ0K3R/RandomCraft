package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerPhantom_Enchantment extends SpawnerWrapper {
    public SpawnerPhantom_Enchantment() {
        super(EntityType.PHANTOM);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Phantom Spawner";
    }
}
