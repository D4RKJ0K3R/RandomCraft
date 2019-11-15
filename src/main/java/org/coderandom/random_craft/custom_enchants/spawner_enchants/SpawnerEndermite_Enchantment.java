package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerEndermite_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerEndermite_Enchantment() {
        super(EntityType.ENDERMITE);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Endermite Spawner";
    }
}
