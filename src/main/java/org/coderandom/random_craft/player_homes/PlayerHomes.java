package org.coderandom.random_craft.player_homes;

import org.bson.Document;
import org.bukkit.Location;
import org.coderandom.random_craft.RandomCraft;
import org.coderandom.random_craft.player_homes.commands.DeleteHome;
import org.coderandom.random_craft.player_homes.commands.Home;
import org.coderandom.random_craft.player_homes.commands.Homes;
import org.coderandom.random_craft.player_homes.commands.SetHome;
import org.coderandom.random_craft.player_homes.commands.tab_completers.HomesTabCompleter;
import org.coderandom.random_craft.utils.CollectionUtil;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class PlayerHomes extends CollectionUtil {

    public PlayerHomes() {
        super("PlayerHomes", true);

        //register commands
        RandomCraft.add("sethome", new SetHome());
        RandomCraft.add("home", new Home(), new HomesTabCompleter());
        RandomCraft.add("deletehome", new DeleteHome(), new HomesTabCompleter());
        RandomCraft.add("homes", new Homes());
    }

    public Location getHome(UUID uuid, String name) {
        Map<String, Object> locationDoc = (Document) this.get(uuid.toString(), name.toLowerCase());

        try {
            return Location.deserialize(locationDoc);
        } catch (NullPointerException e) {
            return null;
        }
    }

    public void removeHome(UUID uuid, String name) {
        this.remove(uuid.toString(), name);
    }

    public void setHome(UUID uuid, String name, Location location) {
        this.set(uuid.toString(), name.toLowerCase(), location.serialize());
    }

    public boolean isHomeSet(UUID uuid, String name) {
        return (getHome(uuid, name.toLowerCase()) != null);
    }

    public Map<String, Object> getHomes(UUID uuid) {
        return this.getData(uuid.toString());
    }

    public List<String> getHomesList(UUID uuid) {
        return this.listKeys(uuid.toString());
    }
}
