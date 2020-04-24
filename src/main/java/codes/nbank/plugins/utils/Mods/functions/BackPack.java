package codes.nbank.plugins.utils.Mods.functions;

import codes.nbank.plugins.utils.system.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class BackPack implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }
        String backpackPrefix = Messages.commandPrefix("Backpack");


        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();

            Inventory backpack = Bukkit.createInventory(player, 1, player.getDisplayName() + "'s Rucksack");

            player.openInventory(backpack);

            System.out.println(backpack.getContents());
        }
        return true;
    }
}

