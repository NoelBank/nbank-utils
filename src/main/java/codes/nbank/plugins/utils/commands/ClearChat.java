package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!sender.isOp()) {
            sender.sendMessage(new Chat().missingPermissionMessage());
            return true;
        }


        for (int i = 0; i < 100; i++) {
            sender.getServer().broadcastMessage("");
        }

        String clearchat = new Chat().commandPrefix("ClearChat");


        if (sender instanceof Player) {

            sender.getServer().broadcastMessage(clearchat + "Der Chat wurde von §e" + ((Player) sender).getPlayer().getDisplayName() + "§7 geleert");
        } else {
            sender.getServer().broadcastMessage(clearchat + "Der Chat wurde von §e" + sender.getName() + "§7 geleert");
        }

        return true;
    }
}

