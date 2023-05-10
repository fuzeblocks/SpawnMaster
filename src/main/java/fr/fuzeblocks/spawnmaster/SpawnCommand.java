package fr.fuzeblocks.spawnmaster;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {
    private SpawnMaster config;
    public SpawnCommand(SpawnMaster config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seule un joueur peut definir le spawn");
            System.out.println("SpawnMaster : La console a execute la commande /spawn");
            return false;
        }
        if (!player.hasPermission("SpawnMaster.spawn")) {
            player.sendMessage(ChatColor.RED + "Desoler mais tu n'as pas la permission !");
            return false;
        } else if (player.hasPermission("SpawnMaster.spawn")) {
            double Y = config.getConfig().getInt("LocationY");
            double X = config.getConfig().getInt("LocationX");
            double Z = config.getConfig().getInt("LocationZ");
            Location location = new Location(player.getWorld(), X, Y, Z);
            player.teleport(location);
            player.sendMessage(ChatColor.RED + "Vous avez etes teleporte au spawn");
            config.saveConfig();


        }

        return false;
    }
}
