package codes.nbank.plugins.utils.listener;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;

import java.util.UUID;

public class Ban implements Listener {


    @EventHandler
    public void onPreLogin(AsyncPlayerPreLoginEvent player) {
        UUID id = player.getUniqueId();
        UUID bannedID = UUID.randomUUID();


        /**
         * set random banned id until their is no connection to database
         */
        if (id == bannedID) {
            player.disallow(AsyncPlayerPreLoginEvent.Result.KICK_BANNED, "§7Du wurdest vom Server gebannt\n" +
                    "Grund dafür ist §8HACKING §7\n" +
                    "\n" +
                    "Du wurdest von §8SEHNDE§7 bis zum §820.06.2020 §7gebannt \n" +
                    "\n" +
                    "ts.nbank.tech");
        }
    }
}
