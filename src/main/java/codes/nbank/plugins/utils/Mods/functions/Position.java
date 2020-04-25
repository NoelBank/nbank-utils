package codes.nbank.plugins.utils.Mods.functions;

import codes.nbank.plugins.utils.system.Messages;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.*;

public class Position implements CommandExecutor, TabCompleter {

    public static Map<String, Location> positionsList = new HashMap<String, Location>();



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

        String positionPrefix = Messages.commandPrefix("Position");

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (args.length == 0) {

                if (positionsList.isEmpty()) {
                    player.sendMessage(positionPrefix + "Es gibt noch §ekeine§7 Positionen§7");

                } else {
                    TextComponent message = new TextComponent(positionPrefix);
                    TextComponent baseMessage = new TextComponent("Es gibt folgende Positionen§7: §e");
                    message.addExtra(baseMessage);
                    message.addExtra(positionsFormated(positionsList));

                    player.spigot().sendMessage(message);
                }

            } else if (args.length == 1) {
                if (positionsList.containsKey(args[0])) {
                    Location loc = positionsList.get(args[0]);
                    player.sendMessage(positionPrefix + "Die Position von §e" + args[0] + "§7 lautet §7[§e" + loc.getBlockX() + "§7, §e" + loc.getBlockY() + "§7, §e" + loc.getBlockZ() + "§7, §e" + Messages.getWorldName(loc.getWorld().getName()) + "§7]");
                } else {
                    positionsList.put(args[0], player.getLocation());
                    System.out.println(player.getLocation());

                    player.sendMessage(positionPrefix + "Du hast §e" + args[0] + "§7 in die Positions-Liste hinzugefügt");
                }
            } else if (args.length == 2) {
                if (args[0].equalsIgnoreCase("delete") && positionsList.containsKey(args[1])) {
                    positionsList.remove(args[1]);
                    player.sendMessage(positionPrefix + "Die Position §e" + args[1] + "§7 wurde gelöscht");
                }
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if (args.length == 1) {
            commands.add("delete");

            for (String position : positionsList.keySet()) {
                commands.add(position);
            }

            StringUtil.copyPartialMatches(args[0], commands, completions);

        } else if (args.length == 2 && args[0].startsWith("delete", 3)) {

            for (String position : positionsList.keySet()) {
                commands.add(position);
            }

        }

        Collections.sort(completions);
        return completions;
    }

}

