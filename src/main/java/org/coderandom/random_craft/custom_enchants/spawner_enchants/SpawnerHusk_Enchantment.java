package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerHusk_Enchantment extends SpawnerWrapper {
    public SpawnerHusk_Enchantment() {
        super(EntityType.HUSK);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Husk Spawner";
    }
}
