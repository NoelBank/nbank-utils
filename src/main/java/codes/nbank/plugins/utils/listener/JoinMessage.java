package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.Database;
import codes.nbank.plugins.utils.Mods.handler.TabList;
import codes.nbank.plugins.utils.Utils;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
    MongoCollection playerCollection = null;
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new TabList().setScoreboard(event.getPlayer());
        Player player = event.getPlayer();
        event.setJoinMessage("§2» §7" + player.getDisplayName());
        String playerUUID = player.getUniqueId().toString();


        playerCollection = Database.mongoDatabase.getCollection(playerUUID);

        if(playerCollection == null) {
            Database.mongoDatabase.createCollection(playerUUID);
            playerCollection = Database.mongoDatabase.getCollection(playerUUID);
        }

        Document playerInfo = new Document("uuid", event.getPlayer().getUniqueId().toString()).append("name", player.getName());

        playerCollection.insertOne(playerInfo);
    }
}
