package org.coderandom.random_craft;

import org.coderandom.random_craft.events.SpongeListener;
import org.coderandom.random_craft.events.StatEvents;

class EventManager {
    EventManager() {
        RandomCraft.add(new StatEvents());
        RandomCraft.add(new SpongeListener());
    }
}
