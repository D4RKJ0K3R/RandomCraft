package org.coderandom.random_craft;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.coderandom.random_craft.custom_enchants.CustomEnchants;
import org.coderandom.random_craft.player_homes.PlayerHomes;
import org.coderandom.random_craft.questing.QuestManager;
import org.coderandom.random_craft.skulls.SkullsManager;
import org.coderandom.random_craft.utils.NMS;
import org.coderandom.random_craft.utils.NMS_1_14_4;
import org.coderandom.random_craft.utils.TeleportBuffer;
import org.coderandom.random_craft.utils.YamlUtil;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public final class RandomCraft extends JavaPlugin {
    private static JavaPlugin instance;
    private static MongoDatabase database;
    private static FileConfiguration config;
    private MongoClient client;
    private static NMS nms;
    private static QuestManager questManager;
    private static TeleportBuffer teleportBuffer;
    private static PlayerHomes playerHomes;

    public RandomCraft() {
        instance = this;
        config = new YamlUtil(instance, "config.yml", true).getFile();
        client = MongoClients.create(Objects.requireNonNull(config.getString("MongoDB Connection String")));
        database = client.getDatabase("NewData");
        nms = new NMS_1_14_4();
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        teleportBuffer = new TeleportBuffer(config.getInt("Teleport Cool Down"));
        playerHomes = new PlayerHomes();
        questManager = new QuestManager();
        new SkullsManager();
        new EventManager();
        new CommandManager();
        new CustomEnchants();

        add("test", new TESTCOMMAND());
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.STONE,120));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.COAL_ORE,190));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.IRON_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.GOLD_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.REDSTONE_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.LAPIS_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.DIAMOND_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.EMERALD_ORE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.WET_SPONGE,0));
//        getServer().getOnlinePlayers().forEach(player -> player.setStatistic(Statistic.MINE_BLOCK, Material.NETHER_QUARTZ_ORE,0));

        log("§2Enabled§6!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        log("§2Disabled§6!");
    }

    public static void add(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, instance);
    }

    public static void add(String command, CommandExecutor executor) {
        add(command, executor, null);
    }

    public static void add(String command, CommandExecutor executor, TabCompleter completer) {
        PluginCommand cmd = instance.getCommand(command);

        if (cmd != null) {
            cmd.setExecutor(executor);

            if (completer != null) {
                cmd.setTabCompleter(completer);
            }
        } else {
            log("§4Command §r" + command + "§4 not registered in§r plugin.yml§6!");
        }
    }

    public static void addTeleport(Player player, Location location, int delay) {
        teleportBuffer.addTeleport(player, location, delay);
    }

    public static void log(String message) {
        Bukkit.getConsoleSender().sendMessage("§6[§2RandomCraftCore§6] §r" + message);
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage("§6[§r" + config.getString("Server Name") + "§6] §r" + message);
    }

    public static PlayerHomes getPlayerHomes() {
        return playerHomes;
    }

    public static MongoDatabase getDatabase() {
        return database;
    }

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static FileConfiguration getConfiguration() {
        return config;
    }

    public static NMS getNms() {
        return nms;
    }

    public static QuestManager getQuestManager() {
        return questManager;
    }

    public static int getRandom(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, (max + 1));
    }
}
