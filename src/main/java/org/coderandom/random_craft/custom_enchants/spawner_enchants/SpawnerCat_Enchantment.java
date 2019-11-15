package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerCat_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerCat_Enchantment() {
        super(EntityType.CAT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Cat Spawner";
    }
}
