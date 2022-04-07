package ern.dev.vhutils.listeners;

import ern.dev.vhutils.config.Config;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

public class PlayerListeners implements Listener {

    // Example utility
    @EventHandler
    public void OnInteractAtEntity(PlayerInteractAtEntityEvent e) {

        if (!e.getPlayer().getGameMode().equals(GameMode.CREATIVE) && Config.disableStands)
            e.setCancelled(true);
    }
}
