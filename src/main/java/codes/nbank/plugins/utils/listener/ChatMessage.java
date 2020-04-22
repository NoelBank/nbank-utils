package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatMessage implements Listener {

    // LOW priority makes this event fire before NORMAL priority, so that we can properly rewrite event messages..
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = false)
    public void onChat(AsyncPlayerChatEvent event) {
        event.setFormat(new Chat().getChatPrefix(event.getPlayer()) + event.getMessage());
    }
}
