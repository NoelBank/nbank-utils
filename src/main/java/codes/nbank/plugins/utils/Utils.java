package codes.nbank.plugins.utils;

import codes.nbank.plugins.utils.commands.ClearChat;
import codes.nbank.plugins.utils.commands.Gamemode;
import codes.nbank.plugins.utils.listener.ChatListener;
import codes.nbank.plugins.utils.listener.JoinListener;
import codes.nbank.plugins.utils.listener.QuitListener;
import codes.nbank.plugins.utils.tabcompleter.GamemodeCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class Utils extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("nbank plugin loaded");

        /**
         * This is used for listener
         */
        getServer().getPluginManager().registerEvents(new JoinListener(), this);
        getServer().getPluginManager().registerEvents(new QuitListener(), this);
        getServer().getPluginManager().registerEvents(new ChatListener(), this);


        /**
         * This is used for commands
         *
         * set autocomplete
         */
        getCommand("gamemode").setTabCompleter(new GamemodeCompleter());


        /**
         * set command
         */
        getCommand("gamemode").setExecutor(new Gamemode());
        getCommand("clearchat").setExecutor(new ClearChat());


    }

    @Override
    public void onDisable() {
        System.out.println("nbank plugin disabled");

    }


}