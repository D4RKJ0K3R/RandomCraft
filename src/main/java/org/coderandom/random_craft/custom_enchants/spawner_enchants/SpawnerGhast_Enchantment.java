package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerGhast_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerGhast_Enchantment() {
        super(EntityType.GHAST);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Ghast Spawner";
    }
}
