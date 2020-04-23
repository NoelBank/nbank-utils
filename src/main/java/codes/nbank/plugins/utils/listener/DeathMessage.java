package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathMessage implements Listener {


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent playerEvent) {


        Player player = playerEvent.getEntity();


        /**
         * set custom death messages
         */
        playerEvent.setDeathMessage(new Chat().serverPrefix() + player.getDisplayName() + " ist gestorben.");
    }
}
