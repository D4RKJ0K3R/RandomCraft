package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerTNT_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerTNT_Enchantment() {
        super(EntityType.PRIMED_TNT);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Primed TNT Spawner";
    }
}
