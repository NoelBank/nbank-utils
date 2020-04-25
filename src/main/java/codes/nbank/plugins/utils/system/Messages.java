package codes.nbank.plugins.utils.system;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.WorldType;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Messages {

    public static String commandPrefix(String command) {

        return "§7| §a" + command + " §7» ";
    }

    public  static String serverPrefix() {
        return "§7| §aServer §7» ";
    }


    public static String errorPrefix() {
        return "§7| §cErorr §7» ";
    }

    public static String infoPreifx() {
        return "§7| §9Info §7» ";
    }

    public static String missingPermissionMessage() {
            return errorPrefix()+"Dir fehlen die nötigen Rechte um diesen Command auszuführen";
    }

    public static String chatPrefix(Player player) {
        return getPlayerChatColor(player) + " » ";
    }

    public static String getPlayerChatColor(Player player) {
        if (player.isOp()) {
            return "§4" + player.getDisplayName()+ "§7";
        }

        return "§7"+player.getDisplayName();
    }

    public static String gameModeString(GameMode gamemode) {
        switch (gamemode) {
            case CREATIVE:
                return "Creative";
            case SURVIVAL:
                return "Survival";
            case ADVENTURE:
                return "Adventure";
            case SPECTATOR:
                return "Spectator";
        }
        return "";
    }

    public static String getWorldName(String worldName) {
        switch (worldName) {
            case "world":
                return "Overworld";
            case "nether":
                return "Nether";
            case "end":
                return "End";
        }
        return "";
    }
}


