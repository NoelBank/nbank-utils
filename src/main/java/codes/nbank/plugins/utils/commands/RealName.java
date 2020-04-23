package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class RealName implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        String errorMessage = new Chat().errorPrefix();
        String realNamePrefix = new Chat().commandPrefix("Nick");

        if (!sender.isOp()) {
            sender.sendMessage(new Chat().missingPermissionMessage());
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
            sender.sendMessage(new Chat().errorPrefix() + "Bitte benutze /realname <name>");

        }

        return true;
    }
}

