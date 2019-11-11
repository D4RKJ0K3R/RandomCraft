package org.coderandom.random_craft.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.coderandom.random_craft.RandomCraft;

import java.io.File;
import java.io.IOException;

public class YamlUtil {
    private final File file;
    private static FileConfiguration fileConfiguration;

    public YamlUtil(JavaPlugin plugin, String fileName, int autoSave) {
        this(plugin,fileName, false, autoSave);
    }

    public YamlUtil(JavaPlugin plugin, String fileName, boolean hasDefaults) {
        this(plugin,fileName, hasDefaults, 0);
    }

    public YamlUtil(JavaPlugin plugin, String fileName, boolean hasDefaults, int autoSave) {
        // turn minutes into minecraft ticks for runnable
        autoSave *= 60 * 20;

        // Check to see if file type was set to .yml
        if(!fileName.contains(".yml")) {
            fileName += ".yml";
        }
        this.file = new File(plugin.getDataFolder(), fileName);

        // if the file doesn't exist if not create it
        if (!file.exists()) {
            if (hasDefaults) {
                plugin.saveResource(fileName, false);
                if (file.exists()) {
                    log(fileName + "§2 Copied from " + plugin.getName());
                }
            } else {
                save();
            }
        }

        // Load the file
        reload();

        // If delay time provided set up runnable
        if (autoSave > 0) {
            new BukkitRunnable(){
                @Override
                public void run() {
                    save();
                }
            }.runTaskTimerAsynchronously(plugin, autoSave, autoSave);
        }

    }

    public void save() {
        if(fileConfiguration == null) {
            reload();
        }
        try {
            fileConfiguration.save(file);
            log(file + "§2 saved§6!");
        } catch (IOException e) {
            e.printStackTrace();
            log(file + "§4 failed to save§6!");
        }
    }

    public void reload() {
        try {
            fileConfiguration = YamlConfiguration.loadConfiguration(file);
        } catch (NullPointerException e) {
            e.printStackTrace();
            log(file + "§4 failed to load§6!");
        }
    }

    public FileConfiguration getFile() {
        return fileConfiguration;
    }

    private void log(String msg) {
        RandomCraft.log(msg);
    }
}
