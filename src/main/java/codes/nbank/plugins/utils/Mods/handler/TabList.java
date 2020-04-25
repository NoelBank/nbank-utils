package codes.nbank.plugins.utils.Mods.handler;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

public class TabList {

    private static Team Operator;
    private static Team Player;

    public void setScoreboard(Player player) {
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
        Objective objective = scoreboard.registerNewObjective("tab-list", "", "tablist");

        objective.setDisplaySlot(DisplaySlot.PLAYER_LIST);
            Operator = scoreboard.registerNewTeam("000Operator");
            Operator.setColor(ChatColor.DARK_RED);
            Operator.setSuffix("§4");
            Operator.setDisplayName(player.getDisplayName());
            Operator.setCanSeeFriendlyInvisibles(false);
            Operator.setAllowFriendlyFire(true);

            Player = scoreboard.registerNewTeam("001Player");
            Player.setColor(ChatColor.GRAY);
            Player.setSuffix("§7");
            Player.setDisplayName(player.getDisplayName());
            Player.setCanSeeFriendlyInvisibles(false);
            Player.setAllowFriendlyFire(true);

        for (Player player1 : Bukkit.getOnlinePlayers()) {
            if (player1.isOp()) {
                Operator.addEntry(player1.getDisplayName());
            } else {
                Player.addEntry(player1.getDisplayName());
            }
        }


        player.setScoreboard(scoreboard);

    }
}
