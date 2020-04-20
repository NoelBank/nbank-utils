package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.system.Chat;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {
    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(new Chat().getServerPrefix() + event.getPlayer().getDisplayName() + " hat das Spiel verlassen.");
    }
}
