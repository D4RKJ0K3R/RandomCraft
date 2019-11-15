package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerOcelot_Enchantment extends SpawnerWrapper {
    public SpawnerOcelot_Enchantment() {
        super(EntityType.OCELOT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Ocelot Spawner";
    }
}
