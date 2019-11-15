package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSnowGolem_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSnowGolem_Enchantment() {
        super(EntityType.SNOWMAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Snow Golem Spawner";
    }
}
