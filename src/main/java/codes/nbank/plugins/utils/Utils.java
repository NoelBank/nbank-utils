package codes.nbank.plugins.utils;

import codes.nbank.plugins.utils.Mods.functions.*;
import codes.nbank.plugins.utils.commands.*;
import codes.nbank.plugins.utils.listener.*;

import net.cavecloud.spigot.SpigotApi;
import net.cavecloud.spigot.utils.Server;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;


public final class Utils extends JavaPlugin {
    public FileConfiguration config = getConfig();
    public static String dbPassword;
    public static String serverName;

    @Override
    public void onEnable() {

        /**
         * set default configure stuff
         */
        config.addDefault("dbPassword", "supersecret");
        config.options().copyDefaults(true);
        saveConfig();

        Server self = SpigotApi.getSelfServer();

        System.out.println("nbank plugin loaded");
        System.out.println("Server ID: " + self.getId());

        self.getServerData().setPlayers(Bukkit.getOnlinePlayers().size()).setGameState(SpigotApi.getGamestate("ONLINE")).setMaxplayers(20).setMotd("LOBBY-"+ self.getId());

        SpigotApi.updateSelfServerData();

        serverName = self.getServerGroup().getGroup() + "-" + self.getId();

        /**
         * This is used for listener
         */
        getServer().getPluginManager().registerEvents(new JoinMessage(), this);
        getServer().getPluginManager().registerEvents(new QuitMessage(), this);
        getServer().getPluginManager().registerEvents(new ChatMessage(), this);
        getServer().getPluginManager().registerEvents(new Ban(), this);
        getServer().getPluginManager().registerEvents(new DeathMessage(), this);


        /**
         * This is used for commands
         *
         * set autocomplete
         */
        getCommand("gamemode").setTabCompleter(new GamemodeCommand());
        getCommand("realname").setTabCompleter(new RealName());


        /**
         * set command
         */
        getCommand("gamemode").setExecutor(new GamemodeCommand());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("fly").setExecutor(new Fly());
        getCommand("backpack").setExecutor(new BackPack());
        getCommand("nick").setExecutor(new Nick());
        getCommand("realname").setExecutor(new RealName());
        getCommand("heal").setExecutor(new Heal());
        getCommand("position").setExecutor(new Position());

        /**
         * open database connection
         */

        dbPassword = getConfig().getString("dbPassword");
        Database.connect();


    }

    @Override
    public void onDisable() {
        System.out.println("nbank plugin disabled");
        Database.disconnect();
    }

}