package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.custom_enchants.CustomWrapper;

public class SpawnerLlama_Enchantment extends CustomWrapper.SpawnerWrapper {
    public SpawnerLlama_Enchantment() {
        super(EntityType.LLAMA);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Llama Spawner";
    }
}
