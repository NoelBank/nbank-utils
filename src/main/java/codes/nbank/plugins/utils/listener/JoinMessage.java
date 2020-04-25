package codes.nbank.plugins.utils.listener;

import codes.nbank.plugins.utils.Mods.handler.TabList;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        new TabList().setScoreboard(event.getPlayer());
        event.setJoinMessage("§2» §7" + event.getPlayer().getDisplayName());
    }
}
