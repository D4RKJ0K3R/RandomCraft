package org.coderandom.random_craft.custom_enchants.spawner_enchants;

import org.bukkit.entity.EntityType;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;

public class SpawnerLlama_Enchantment extends SpawnerWrapper {
    public SpawnerLlama_Enchantment() {
        super(EntityType.LLAMA);
        CustomEnchants.register(this);
    }

    @Override
    public String getName() {
        return  "Llama Spawner";
    }
}
