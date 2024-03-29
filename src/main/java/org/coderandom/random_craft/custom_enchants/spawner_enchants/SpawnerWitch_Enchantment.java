package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerWitch_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerWitch_Enchantment() {
        super(EntityType.WITCH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Witch Spawner";
    }
}
