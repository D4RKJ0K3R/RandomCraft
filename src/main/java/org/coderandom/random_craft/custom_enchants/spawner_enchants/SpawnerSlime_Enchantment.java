package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSlime_Enchantment extends SpawnerWrapper {
    public SpawnerSlime_Enchantment() {
        super(EntityType.SLIME);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Slime Spawner";
    }
}
