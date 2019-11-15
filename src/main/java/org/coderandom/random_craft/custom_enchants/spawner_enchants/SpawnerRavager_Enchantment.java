package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerRavager_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerRavager_Enchantment() {
        super(EntityType.RAVAGER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Ravager Spawner";
    }
}
