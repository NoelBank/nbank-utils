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

        MongoCollection collection = Database.mongoDatabase.getCollection("messages");
        Document doc = new Document("uuid", event.getPlayer().getUniqueId().toString())
                .append("displayName",event.getPlayer().getDisplayName())
                .append("name",event.getPlayer().getName())
                .append("timestamp", date.getTime())
                .append("message",event.getMessage())
                .append("server", Utils.serverName);

        collection.insertOne(doc);

        event.setFormat(Messages.chatPrefix(event.getPlayer()) + event.getMessage());
    }


}
