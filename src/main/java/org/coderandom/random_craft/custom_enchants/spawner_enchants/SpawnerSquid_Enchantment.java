package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerSquid_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerSquid_Enchantment() {
        super(EntityType.SQUID);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Squid Spawner";
    }
}
