package codes.nbank.plugins.utils;

import codes.nbank.plugins.utils.commands.*;
import codes.nbank.plugins.utils.listener.*;

import org.bukkit.plugin.java.JavaPlugin;

public final class Utils extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("nbank plugin loaded");

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
        getCommand("gamemode").setTabCompleter(new  codes.nbank.plugins.utils.tabcompleter.Gamemode());
        getCommand("realname").setTabCompleter(new codes.nbank.plugins.utils.tabcompleter.RealName());


        /**
         * set command
         */
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("clearchat").setExecutor(new ClearChat());
        getCommand("fly").setExecutor(new Fly());
        getCommand("backpack").setExecutor(new BackPack());
        getCommand("nick").setExecutor(new Nick());
        getCommand("realname").setExecutor(new RealName());
        getCommand("health").setExecutor(new Health());
    }

    @Override
    public void onDisable() {
        System.out.println("nbank plugin disabled");

    }

}