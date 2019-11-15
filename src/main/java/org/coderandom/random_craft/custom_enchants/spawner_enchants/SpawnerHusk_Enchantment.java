package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerHusk_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerHusk_Enchantment() {
        super(EntityType.HUSK);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Husk Spawner";
    }
}
