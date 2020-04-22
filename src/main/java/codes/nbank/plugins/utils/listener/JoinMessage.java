package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(new Chat().serverPrefix() + event.getPlayer().getDisplayName() + " hat das Spiel betreten.");
    }
}
