package codes.nbank.plugins.utils.system;

import org.bukkit.entity.Player;

import java.util.Optional;

public class Chat {

    public String commandPrefix(String command) {

        return "§7| §a" + command + " §7» ";
    }

    public String serverPrefix() {
        return "§7| §aServer §7» ";
    }


    public String errorPrefix() {
        return "§7| §cErorr §7» ";
    }

    public String infoPreifx() {
        return "§7| §9Info §7» ";
    }

    public String missingPermissionMessage() {
            return errorPrefix()+"Dir fehlen die nötigen Rechte um diesen Command auszuführen";
    }

    public String chatPrefix(Player player) {
        return getPlayerChatColor(player) + " » ";
    }

    public String getPlayerChatColor(Player player) {
        if (player.isOp()) {
            return "§4" + player.getDisplayName()+ "§7";
        }

        return "§7"+player.getDisplayName();
    }
}
