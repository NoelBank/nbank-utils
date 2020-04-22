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


            if (args.length == 0) {
                player.setDisplayName(player.getName());
                sender.sendMessage(new Chat().generateInfoMessage("Dein Nick Name wurde wieder zurückgesetzt"));
            } else if (args.length == 1) {
                player.setDisplayName(args[0]);
                sender.sendMessage(new Chat().generateInfoMessage("Dein Nick Name auf " + args[0] + " gesetzt"));

            } else {
                sender.sendMessage(new Chat().generateErrorMessage("Bitte benutze /nick <name>"));

            }
        }

        return true;
    }
}

