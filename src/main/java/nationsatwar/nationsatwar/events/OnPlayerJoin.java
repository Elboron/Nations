package nationsatwar.nationsatwar.events;

import nationsatwar.nationsatwar.OnlinePlayer;
import org.bukkit.event.player.PlayerJoinEvent;

public class OnPlayerJoin {
    public static void handle(PlayerJoinEvent event) {
        event.setJoinMessage("");
        OnlinePlayer.addPlayer(event.getPlayer());
    }
}
