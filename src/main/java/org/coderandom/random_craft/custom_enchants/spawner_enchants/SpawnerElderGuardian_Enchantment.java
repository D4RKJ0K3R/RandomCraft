package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerElderGuardian_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerElderGuardian_Enchantment() {
        super(EntityType.ELDER_GUARDIAN);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return "Elder Guardian Spawner";
    }
}
