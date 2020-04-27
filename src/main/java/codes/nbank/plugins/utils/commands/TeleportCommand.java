package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeleportCommand implements CommandExecutor, TabCompleter {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        String errorMessage = Messages.errorPrefix();
        String teleportPrefix = Messages.commandPrefix("Teleport");


        if (sender instanceof Player) {
            if (!sender.isOp()) {
                sender.sendMessage(Messages.missingPermissionMessage());
                return true;
            }


            if (args.length == 1 || args.length == 2  || args.length == 3) {

                
            } else {
                sender.sendMessage(errorMessage + "Bitte verwende /tp");
            }
        }
        return true;
    }

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

        } else if (args.length == 2) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                commands.add(player.getDisplayName());
            }

            StringUtil.copyPartialMatches(args[1], commands, completions);

        }

        Collections.sort(completions);
        return completions;
    }


}
