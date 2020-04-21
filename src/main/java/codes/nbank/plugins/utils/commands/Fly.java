package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Fly implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }


        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            Boolean flying = player.getAllowFlight();

            if (args.length == 0) {
                player.setAllowFlight(!flying);
                if (flying == true) {
                    // turn off
                    sender.sendMessage(new Chat().generateInfoMessage("Du hast den Flugmodus beendet"));
                } else {
                    sender.sendMessage(new Chat().generateInfoMessage("Du hast dich in den Flugmodus gesetzt"));

                }

            } else if (args.length == 1) {
                Player targetPlayer = player.getServer().getPlayer(args[0]);
                Boolean targetPlayerFlying = player.getAllowFlight();

                if (targetPlayer != null) {
                    targetPlayer.setAllowFlight(!targetPlayerFlying);

                    if (targetPlayerFlying == true) {

                        targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat den Flugmodus für dich deaktiviert"));
                        sender.sendMessage(new Chat().generateInfoMessage("Du hast für den Spieler " + targetPlayer.getDisplayName()+ " den Flugmodus deaktiviert"));

                    } else {
                    targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat dich in den Flugmodus gesetzt"));
                    sender.sendMessage(new Chat().generateInfoMessage("Du hast den Spieler " + targetPlayer.getDisplayName()+ " in den Flugmodus gesetzt"));
                    }

                } else {
                    sender.sendMessage(new Chat().generateErrorMessage("Der gesuchte Spieler ist nicht Online " + args[1]));

                }



                } else {
                sender.sendMessage("wrong command use");
            }
        }
        return true;
    }
}

