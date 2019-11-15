package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSlime_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSlime_Enchantment() {
        super(EntityType.SLIME);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Slime Spawner";
    }
}
