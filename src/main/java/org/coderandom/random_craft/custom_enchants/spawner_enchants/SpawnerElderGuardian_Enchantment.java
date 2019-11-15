package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerElderGuardian_Enchantment extends SpawnerWrapper {
    public SpawnerElderGuardian_Enchantment() {
        super(EntityType.ELDER_GUARDIAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Elder Guardian Spawner";
    }
}
