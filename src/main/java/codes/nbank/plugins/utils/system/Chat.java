package codes.nbank.plugins.utils.system;

import org.bukkit.entity.Player;

import java.util.Optional;

public class Chat {

    public String getServerPrefix() {
        return "§7[§eSYSTEM§7]";
    }

    public String getMessageSeperator() {
        return "§7 » ";
    }

    public String generateErrorMessage(String errorMessage) {
        return getServerPrefix() + getErrorType(MessageTypes.ErrorMessage) + "§7 » " + errorMessage;
    }
    public String generateInfoMessage(String infoMessage) {
        return getServerPrefix() + getErrorType(MessageTypes.InfoMessage) + "§7 » " + infoMessage;
    }


    public String getErrorType(MessageTypes messageType) {

        switch(messageType) {
            case ErrorMessage:
                return "§c ERROR";
            case InfoMessage:
                return "§9 INFO";
            case WarnMessage:
                return "§1 WARN";
            default:
                return "";
        }

    }

    public enum MessageTypes {
        ErrorMessage,
        InfoMessage,
        WarnMessage,
    }

    public String getChatPrefix(Player player) {
        return getPlayerChatColor(player) + " » ";
    }

    public String getPlayerChatColor(Player player) {
        if (player.isOp()) {
            return "§4" + player.getDisplayName()+ "§7";
        }

        return "§7"+player.getDisplayName();
    }
}
