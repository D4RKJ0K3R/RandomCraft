package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerOcelot_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerOcelot_Enchantment() {
        super(EntityType.OCELOT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Ocelot Spawner";
    }
}
