package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSnowGolem_Enchantment extends SpawnerWrapper {
    public SpawnerSnowGolem_Enchantment() {
        super(EntityType.SNOWMAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Snow Golem Spawner";
    }
}
