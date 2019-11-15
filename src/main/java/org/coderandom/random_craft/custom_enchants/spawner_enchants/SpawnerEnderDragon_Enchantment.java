package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerEnderDragon_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerEnderDragon_Enchantment() {
        super(EntityType.ENDER_DRAGON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Ender Dragon Spawner";
    }
}
