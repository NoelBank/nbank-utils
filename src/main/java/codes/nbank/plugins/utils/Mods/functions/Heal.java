package codes.nbank.plugins.utils.Mods.functions;

import codes.nbank.plugins.utils.system.Messages;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class Heal implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        if (!sender.isOp()) {
            sender.sendMessage(Messages.missingPermissionMessage());
            return true;
        }


        String errorMessage = Messages.errorPrefix();
        String healthPrefix = Messages.commandPrefix("Health");

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            if (args.length == 0) {
                sender.sendMessage(healthPrefix + "Du hast dich §egeheilt§7");
                player.setHealth(20);
                player.setFoodLevel(20);

            } else if (args.length == 1) {
                Player targetPlayer = player.getServer().getPlayer(args[0]);

                if (targetPlayer != null) {

                    targetPlayer.setHealth(20);
                    targetPlayer.setFoodLevel(20);

                    targetPlayer.sendMessage(healthPrefix + "Der Spieler §e" + player.getDisplayName() + "§7 hat dich geheilt");
                    sender.sendMessage(healthPrefix + "Du hast den Spieler §e" + targetPlayer.getDisplayName() + "§7 geheilt");

                } else {
                    sender.sendMessage(healthPrefix + "Der gesuchte Spieler ist nicht Online §e" + args[1]);

                }


            } else {
                sender.sendMessage(errorMessage + "Bitte vewende /health <name>");
            }
        }
        return true;
    }
}

