package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerMooshroom_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerMooshroom_Enchantment() {
        super(EntityType.MUSHROOM_COW);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Mooshroom Spawner";
    }
}
