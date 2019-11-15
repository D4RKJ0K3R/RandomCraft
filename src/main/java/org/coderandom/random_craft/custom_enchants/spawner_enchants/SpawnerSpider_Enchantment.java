package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSpider_Enchantment extends SpawnerWrapper {
    public SpawnerSpider_Enchantment() {
        super(EntityType.SPIDER);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Spider Spawner";
    }
}
