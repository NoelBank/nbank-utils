package codes.nbank.plugins.utils.Mods.functions;

import codes.nbank.plugins.utils.system.Messages;
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

        String errorMessage = Messages.errorPrefix();
        String realNamePrefix = Messages.commandPrefix("Fly");

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            Boolean flying = player.getAllowFlight();

            if (args.length == 0) {
                player.setAllowFlight(!flying);
                if (flying == true) {
                    // turn off
                    sender.sendMessage(realNamePrefix + "Du hast den §eFlugmodus§7 beendet");
                } else {
                    sender.sendMessage(realNamePrefix + "Du hast dich in den §eFlugmodus§7 gesetzt");

                }

            } else if (args.length == 1) {
                Player targetPlayer = player.getServer().getPlayer(args[0]);
                Boolean targetPlayerFlying = player.getAllowFlight();

                if (!sender.isOp()) {
                    sender.sendMessage(Messages.missingPermissionMessage());
                    return true;
                }

                if (targetPlayer != null) {

                    if (targetPlayerFlying == true) {
                        targetPlayer.setAllowFlight(true);

                        targetPlayer.sendMessage(realNamePrefix + "Der Spieler §e" + player.getDisplayName() + "§7 hat den Flugmodus für dich deaktiviert");
                        sender.sendMessage(realNamePrefix + "Du hast für den Spieler §e" + targetPlayer.getDisplayName() + "§7 den Flugmodus deaktiviert");
                    } else {
                        targetPlayer.setAllowFlight(false);

                        targetPlayer.sendMessage(realNamePrefix + "Der Spieler §e" + player.getDisplayName() + "§7 hat dich in den Flugmodus gesetzt");
                        sender.sendMessage(realNamePrefix + "Du hast den Spieler §e" + targetPlayer.getDisplayName() + "§7 in den Flugmodus gesetzt");
                    }

                } else {
                    sender.sendMessage(realNamePrefix + "Der gesuchte Spieler ist nicht Online §e" + args[1]);

                }


            } else {
                sender.sendMessage(errorMessage + "Bitte vewende /fly <name>");
            }
        }
        return true;
    }
}

