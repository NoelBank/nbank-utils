package codes.nbank.plugins.utils;

import codes.nbank.plugins.utils.Mods.functions.*;
import codes.nbank.plugins.utils.commands.*;
import codes.nbank.plugins.utils.listener.*;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

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




    }

    @Override
    public void onDisable() {
        System.out.println("nbank plugin disabled");


    }

}