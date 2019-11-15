package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerRavager_Enchantment extends SpawnerWrapper {
    public SpawnerRavager_Enchantment() {
        super(EntityType.RAVAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Ravager Spawner";
    }
}
