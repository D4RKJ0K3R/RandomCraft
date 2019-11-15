package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerDolphin_Enchantment extends SpawnerWrapper {
    public SpawnerDolphin_Enchantment() {
        super(EntityType.DOLPHIN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Dolphin Spawner";
    }
}
