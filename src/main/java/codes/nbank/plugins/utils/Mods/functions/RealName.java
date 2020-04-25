package codes.nbank.plugins.utils.Mods.functions;

import codes.nbank.plugins.utils.system.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RealName implements CommandExecutor, TabCompleter {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String errorMessage = Messages.errorPrefix();
        String realNamePrefix = Messages.commandPrefix("Nick");

        if (!sender.isOp()) {
            sender.sendMessage(Messages.missingPermissionMessage());
            return true;
        }

        if (args.length == 0) {
            sender.sendMessage(errorMessage + "Bitte benutze /realname <name>");

        } else if (args.length == 1) {
            for (Player player : sender.getServer().getOnlinePlayers()) {

                if (player.getDisplayName().equalsIgnoreCase(args[0])) {
                    sender.sendMessage(realNamePrefix + "Der echte Name von §e" + player.getDisplayName() + "§7 lautet §e" + player.getName());
                } else {
                    sender.sendMessage(realNamePrefix + "Der Spieler §e" + args[0] + "§7 ist nicht Online");

                }

            }


        } else {
            sender.sendMessage(Messages.errorPrefix() + "Bitte benutze /realname <name>");

        }

        return true;
    }

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

