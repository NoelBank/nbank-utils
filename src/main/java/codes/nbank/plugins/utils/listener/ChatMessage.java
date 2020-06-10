package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.Database;
import codes.nbank.plugins.utils.Utils;
import codes.nbank.plugins.utils.system.Messages;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Date;


public class ChatMessage implements Listener {
    Date date= new Date();

    // LOW priority makes this event fire before NORMAL priority, so that we can properly rewrite event messages..
    @EventHandler(priority = EventPriority.LOW, ignoreCancelled = false)
    public void onChat(AsyncPlayerChatEvent event) {


        event.setFormat(Messages.chatPrefix(event.getPlayer()) + event.getMessage());
    }


}
