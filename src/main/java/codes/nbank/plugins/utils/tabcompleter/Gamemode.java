package codes.nbank.plugins.utils.tabcompleter;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Gamemode implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();


        if (args.length == 1) {
            commands.add("0");
            commands.add("1");
            commands.add("2");
            commands.add("3");
            commands.add("survival");
            commands.add("creative");
            commands.add("adventure");
            commands.add("spectator");

            StringUtil.copyPartialMatches(args[0], commands, completions);

        } else  if (args.length == 2) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                commands.add(player.getDisplayName());
            }

            StringUtil.copyPartialMatches(args[1], commands, completions);

        }


        Collections.sort(completions);
        return completions;
    }


}
