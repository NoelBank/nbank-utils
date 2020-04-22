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


        if (args.length == 0) {
            sender.sendMessage(new Chat().generateErrorMessage("Bitte benutze /realname <name>"));

        } else if (args.length == 1) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                if (player.getDisplayName().equalsIgnoreCase(args[0])) {
                    sender.sendMessage(new Chat().generateInfoMessage("Der echte Name von " + player.getDisplayName() + " lautet " + player.getName()));
                } else {
                    sender.sendMessage(new Chat().generateErrorMessage("Der Spieler ist nicht Online"));

                }

            }


        } else {
            sender.sendMessage(new Chat().generateErrorMessage("Bitte benutze /realname <name>"));

        }

        return true;
    }
}

