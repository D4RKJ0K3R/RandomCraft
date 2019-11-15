package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSilverFish_Enchantment extends SpawnerWrapper {
    public SpawnerSilverFish_Enchantment() {
        super(EntityType.SILVERFISH);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Silver Fish Spawner";
    }
}
