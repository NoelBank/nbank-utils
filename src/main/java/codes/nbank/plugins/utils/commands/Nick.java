package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Nick implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            String errorMessage = new Chat().errorPrefix();
            String realNamePrefix = new Chat().commandPrefix("Nick");


            if (args.length == 0) {
                player.setDisplayName(player.getName());
                sender.sendMessage(realNamePrefix + "Dein §eNickname§7 wurde wieder zurückgesetzt");
            } else if (args.length == 1) {
                player.setDisplayName(args[0]);
                sender.sendMessage(realNamePrefix + "Du hast deinen §eNickname§7 auf §e" + args[0] + " §7geändert");

            } else {
                sender.sendMessage(errorMessage + "Bitte benutze /nick <name>");

            }
        }

        return true;
    }
}

