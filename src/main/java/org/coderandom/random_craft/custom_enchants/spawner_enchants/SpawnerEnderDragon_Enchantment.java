package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerEnderDragon_Enchantment extends SpawnerWrapper {
    public SpawnerEnderDragon_Enchantment() {
        super(EntityType.ENDER_DRAGON);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Ender Dragon Spawner";
    }
}
