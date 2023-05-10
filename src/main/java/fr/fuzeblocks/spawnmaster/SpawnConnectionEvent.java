package fr.fuzeblocks.spawnmaster;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.entity.Player;

public class SpawnConnectionEvent implements Listener {
    private SpawnMaster config;

    public SpawnConnectionEvent(SpawnMaster config) {
        this.config = config;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        Boolean a = config.getConfig().getBoolean("Tponspawn");
        if (a == true) {
            double x = config.getConfig().getDouble("LocationX");
            double y = config.getConfig().getDouble("LocationY");
            double z = config.getConfig().getDouble("LocationZ");
            Location location = new Location(player.getWorld(), x, y, z);
            player.teleport(location);
            player.sendMessage(ChatColor.RED + "Vous avez ete automatiquement teleporte au spawn");

            config.saveConfig();
        }
    }
}