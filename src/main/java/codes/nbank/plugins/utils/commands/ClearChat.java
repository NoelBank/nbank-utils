package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;

public class ClearChat implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {

        for (int i = 0; i < 100; i++){
            sender.getServer().broadcastMessage("");
        }

        sender.getServer().broadcastMessage(new Chat().generateInfoMessage("Der Chat wurde von " + sender.getName() + " geleert"));

        return true;
    }
}

