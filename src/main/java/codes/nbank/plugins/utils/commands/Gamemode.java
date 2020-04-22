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

    private String getGamemodeMessage(String gamemode) {
        return "Dein §eSpielmodus §7wurde zu §e" + gamemode + "§7 geändert";
    }

    private String getTargetGamemodeMessage(String playerName, String gamemode) {
        return "Dein §eSpielmodus §7wurde von §e" + playerName + "§7 zu §e" + gamemode + "§7 geändert";
    }

    private String getSenderGamemodeMessage(String playerName, String gamemode) {
        return "Der §eSpielmodus §7von §e" + playerName + "§7 wurde zu §e" + gamemode + "§7 geändert";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }



        String errorMessage = new Chat().errorPrefix();
        String gamemodePrefix = new Chat().commandPrefix("Gamemode");


        if (sender instanceof Player) {
            Player player = ((Player) sender).getPlayer();
            if(!player.isOp()) {
                sender.sendMessage(new Chat().missingPermissionMessage());
                return true;
            }

            if (args.length <= 0) {
                sender.sendMessage(errorMessage + "Bitte verwende /gamemode <stufe> <spieler>");
            } else {
                // this should be if user has set 1,2... creative...
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                        player.setGameMode(GameMode.SURVIVAL);
                        sender.sendMessage(gamemodePrefix + getGamemodeMessage("SURVIVAL"));

                    } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                        player.setGameMode(GameMode.CREATIVE);
                        sender.sendMessage(gamemodePrefix + getGamemodeMessage("CREATIVE"));

                    } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                        player.setGameMode(GameMode.ADVENTURE);
                        sender.sendMessage(gamemodePrefix + getGamemodeMessage("ADVENTURE"));

                    } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                        player.setGameMode(GameMode.SPECTATOR);
                        sender.sendMessage(gamemodePrefix + getGamemodeMessage("SPECTATOR"));

                    } else {
                        sender.sendMessage(errorMessage + "Diesen §eSpielmodus§7 kennt das System nicht " + args[0]);
                    }
                }
                // this should be if user sets name of person
                if (args.length == 2) {
                    Player targetPlayer = player.getServer().getPlayer(args[1]);
                    if (targetPlayer != null) {
                        if (args[0].equalsIgnoreCase("0") || args[0].equalsIgnoreCase("survival")) {
                            targetPlayer.setGameMode(GameMode.SURVIVAL);
                            targetPlayer.sendMessage(gamemodePrefix + getTargetGamemodeMessage(player.getDisplayName(), "SURVIVAL"));
                            sender.sendMessage(gamemodePrefix + getSenderGamemodeMessage(targetPlayer.getDisplayName(), "SURVIVAL"));

                        } else if (args[0].equalsIgnoreCase("1") || args[0].equalsIgnoreCase("creative")) {
                            targetPlayer.setGameMode(GameMode.CREATIVE);
                            targetPlayer.sendMessage(gamemodePrefix + getTargetGamemodeMessage(player.getDisplayName(), "CREATIVE"));
                            sender.sendMessage(gamemodePrefix + getSenderGamemodeMessage(targetPlayer.getDisplayName(), "CREATIVE"));

                        } else if (args[0].equalsIgnoreCase("2") || args[0].equalsIgnoreCase("adventure")) {
                            targetPlayer.setGameMode(GameMode.ADVENTURE);
                            targetPlayer.sendMessage(gamemodePrefix + getTargetGamemodeMessage(player.getDisplayName(), "ADVENTURE"));
                            sender.sendMessage(gamemodePrefix + getSenderGamemodeMessage(targetPlayer.getDisplayName(), "ADVENTURE"));

                        } else if (args[0].equalsIgnoreCase("3") || args[0].equalsIgnoreCase("spectator")) {
                            targetPlayer.setGameMode(GameMode.SPECTATOR);
                            targetPlayer.sendMessage(gamemodePrefix + getTargetGamemodeMessage(player.getDisplayName(), "SPECTATOR"));
                            sender.sendMessage(gamemodePrefix + getSenderGamemodeMessage(targetPlayer.getDisplayName(), "SPECTATOR"));

                        } else {
                            sender.sendMessage(errorMessage + "Diesen Spielmodus kennt das System nicht " + args[0]);
                        }

                    } else {
                        sender.sendMessage(errorMessage + "Der gesuchte Spieler ist nicht Online " + args[1]);

                    }
                }

                if (args.length >= 3) {
                    sender.sendMessage(errorMessage + "Bitte verwende /gamemode <stufe> <spieler>");
                }
            }
        }

        return true;
    }


}
