package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.Utils;
import codes.nbank.plugins.utils.system.Chat;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.*;

public class Position implements CommandExecutor {

    private TextComponent positionsFormated(Map<String, Location> positions) {
        TextComponent positionText = new TextComponent("");

        for (String position : positions.keySet()) {
            TextComponent message = new TextComponent(position);
            TextComponent separator = new TextComponent("§7, §e");
            message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/position " + position));
            message.setColor(ChatColor.YELLOW);

            positionText.addExtra(message);
            positionText.addExtra(separator);
        }


        return positionText;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        String positionPrefix = new Chat().commandPrefix("Position");

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (args.length == 0) {

                if (Utils.positionsList.isEmpty()) {
                    player.sendMessage(positionPrefix + "Es gibt noch §ekeine§7 Positionen§7");

                } else {
                    TextComponent message = new TextComponent(positionPrefix);
                    TextComponent baseMessage = new TextComponent("Es gibt folgende Positionen§7: §e");
                    message.addExtra(baseMessage);
                    message.addExtra(positionsFormated(Utils.positionsList));

                    player.spigot().sendMessage(message);
                }

            } else if (args.length == 1) {
                if (Utils.positionsList.containsKey(args[0])) {
                    Location loc = Utils.positionsList.get(args[0]);
                    player.sendMessage(positionPrefix + "Die Position von §e" + args[0] + "§7 lautet [§eX§7]: §e" + loc.getBlockX() + " §7[§eY§7]: §e" + loc.getBlockY() + " §7[§eZ§7]: §e" + loc.getBlockZ());
                } else {
                    Utils.positionsList.put(args[0], player.getLocation());
                    player.sendMessage(positionPrefix + "Du hast §e" + args[0] + "§7 in die Positions-Liste hinzugefügt");
                }
            }
        }
        return true;
    }
}

