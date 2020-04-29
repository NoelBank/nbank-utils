package codes.nbank.plugins.utils.commands;

import codes.nbank.plugins.utils.system.Messages;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GamemodeCommand implements CommandExecutor, TabCompleter {

    private String getGamemodeMessage(GameMode gamemode) {
        return "Dein §eSpielmodus §7wurde zu §e" + Messages.gameModeString(gamemode) + "§7 geändert";
    }

    private String getTargetGamemodeMessage(String playerName, GameMode gamemode) {
        return "Dein §eSpielmodus §7wurde von §e" + playerName + "§7 zu §e" + Messages.gameModeString(gamemode) + "§7 geändert";
    }

    private String getSenderGamemodeMessage(String playerName, GameMode gamemode) {
        return "Der §eSpielmodus §7von §e" + playerName + "§7 wurde zu §e" + Messages.gameModeString(gamemode) + "§7 geändert";
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            System.out.println("you are not a Player!");
            return false;
        }

        String errorMessage = Messages.errorPrefix();
        String gamemodePrefix = Messages.commandPrefix("Gamemode");


        if (sender instanceof Player) {
            if (!sender.isOp()) {
                sender.sendMessage(Messages.missingPermissionMessage());
                return true;
            }

            GameMode gameMode = null;

            if (args.length == 1 || args.length == 2) {
                switch (args[0]) {
                    case "survival":
                    case "0":
                        gameMode = GameMode.SURVIVAL;
                        break;
                    case "creative":
                    case "1":
                        gameMode = GameMode.CREATIVE;
                        break;
                    case "adventure":
                    case "2":
                        gameMode = GameMode.ADVENTURE;
                        break;
                    case "spectator":
                    case "3":
                        gameMode = GameMode.SPECTATOR;
                        break;
                }

                if (gameMode != null) {
                    if (args.length == 1) {
                        if (sender instanceof Player) {
                            sender.sendMessage(gamemodePrefix + getGamemodeMessage(gameMode));
                            ((Player) sender).getPlayer().setGameMode(gameMode);
                        } else {
                            sender.sendMessage(errorMessage + "Du kannst dich nicht in einen Gamemode Setzen");
                        }
                    } else if (args.length == 2) {
                        Player targetPlayer = ((Player) sender).getServer().getPlayer(args[1]);

                        if (targetPlayer != null) {
                            targetPlayer.setGameMode(gameMode);
                            targetPlayer.sendMessage(gamemodePrefix + getTargetGamemodeMessage(((Player) sender).getPlayer().getDisplayName(), gameMode));
                            sender.sendMessage(gamemodePrefix + getSenderGamemodeMessage(targetPlayer.getDisplayName(), gameMode));
                        } else {
                            sender.sendMessage(errorMessage + "Der gewünschte Spieler ist nicht verfügbar");
                        }

                    }
                } else {
                    sender.sendMessage(errorMessage + "Dieser §eGamemode §7ist unbekannt");
                }
            } else {
                sender.sendMessage(errorMessage + "Bitte verwende /gamemode [stufe] <spieler>");
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();

        if (args.length == 1) {
            commands.add("0");
            commands.add("1");
            commands.add("2");
            commands.add("3");
            commands.add("survival");
            commands.add("creative");
            commands.add("adventure");
            commands.add("spectator");

            StringUtil.copyPartialMatches(args[0], commands, completions);

        } else if (args.length == 2) {
            for (Player player : sender.getServer().getOnlinePlayers()) {
                commands.add(player.getDisplayName());
            }

            StringUtil.copyPartialMatches(args[1], commands, completions);

        }

        Collections.sort(completions);
        return completions;
    }


}
