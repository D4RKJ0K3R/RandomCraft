package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerEnderman_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerEnderman_Enchantment() {
        super(EntityType.ENDERMAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Enderman Spawner";
    }
}
