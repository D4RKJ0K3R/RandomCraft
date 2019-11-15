package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerSquid_Enchantment extends SpawnerWrapper {
    public SpawnerSquid_Enchantment() {
        super(EntityType.SQUID);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Squid Spawner";
    }
}
