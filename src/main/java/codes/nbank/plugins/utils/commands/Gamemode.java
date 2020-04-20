package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Gamemode implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if (args.length <= 0) {
                sender.sendMessage(new Chat().generateErrorMessage("Bitte verwende /gamemode <stufe> <spieler>"));
            } else {
                // this should be if user has set 1,2... creative...
                if(args.length == 1) {
                    if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(new Chat().generateInfoMessage("Du bis nun im Gamemode SURVIVAL"));

                    } else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(new Chat().generateInfoMessage("Du bis nun im Gamemode CREATIVE"));

                    } else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase( "adventure")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(new Chat().generateInfoMessage("Du bis nun im Gamemode ADVENTURE"));

                    } else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(new Chat().generateInfoMessage("Du bis nun im Gamemode SPECTATOR"));

                    } else {
                        sender.sendMessage(new Chat().generateErrorMessage("Diesen Gamemode kennt das System nicht " + args[0]));
                    }
                }
                // this should be if user sets name of person
                if(args.length == 2) {
                    Player targetPlayer = player.getServer().getPlayer(args[1]);
                    if (targetPlayer != null) {
                        if(args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                            targetPlayer.setGameMode(GameMode.SURVIVAL);
                            targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat dich in den Gamemode SURVIVAL gesetzt"));
                            sender.sendMessage(new Chat().generateInfoMessage("Du hast den Spieler " + targetPlayer.getDisplayName()+ " in den Gamemode SURVIVAL gesetzt"));

                        } else if(args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                            targetPlayer.setGameMode(GameMode.CREATIVE);
                            targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat dich in den Gamemode CREATIVE gesetzt"));
                            sender.sendMessage(new Chat().generateInfoMessage("Du hast den Spieler " + targetPlayer.getDisplayName()+ " in den Gamemode CREATIVE gesetzt"));

                        } else if(args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase( "adventure")) {
                            targetPlayer.setGameMode(GameMode.ADVENTURE);
                            targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat dich in den Gamemode ADVENTURE gesetzt"));
                            sender.sendMessage(new Chat().generateInfoMessage("Du hast den Spieler " + targetPlayer.getDisplayName()+ " in den Gamemode ADVENTURE gesetzt"));

                        } else if(args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                            targetPlayer.setGameMode(GameMode.SPECTATOR);
                            targetPlayer.sendMessage(new Chat().generateInfoMessage("Der Spieler " + player.getDisplayName() + " hat dich in den Gamemode SPECTATOR gesetzt"));
                            sender.sendMessage(new Chat().generateInfoMessage("Du hast den Spieler " + targetPlayer.getDisplayName()+ " in den Gamemode SPECTATOR gesetzt"));

                        } else {
                            sender.sendMessage(new Chat().generateErrorMessage("Diesen Gamemode kennt das System nicht " + args[0]));
                        }

                    } else {
                        sender.sendMessage(new Chat().generateErrorMessage("Der gesuchte Spieler ist nicht Online " + args[1]));

                    }
                }

                if(args.length >= 3) {
                    sender.sendMessage(new Chat().generateErrorMessage("Bitte verwende /gamemode <stufe> <spieler>"));
                }
            }
        }

        return true;
    }


}
