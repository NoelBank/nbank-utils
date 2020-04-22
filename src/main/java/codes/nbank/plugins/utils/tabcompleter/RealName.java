package codes.nbank.plugins.utils.tabcompleter;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RealName implements TabCompleter {

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();


        if (args.length == 1) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                commands.add(player.getDisplayName());
            }


            StringUtil.copyPartialMatches(args[0], commands, completions);

        }


        Collections.sort(completions);
        return completions;
    }


}
