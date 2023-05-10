package fr.fuzeblocks.spawnmaster;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;



public class SetspawnCommand implements CommandExecutor {
    private SpawnMaster config;

    public SetspawnCommand(SpawnMaster config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        FileConfiguration configuration = config.getConfig();
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seule un joueur peut definir le setspawn");
            System.out.println("SpawnMaster : La console a execute la commande /setspawn");
            return false;
        }
        if (!player.hasPermission("SpawnMaster.setspawn")) {
            player.sendMessage(ChatColor.RED + "Desoler mais tu n'as pas la permission !");
            return false;
        } else if (player.hasPermission("SpawnMaster.setspawn")) {
            int locationz = player.getLocation().getBlockZ();
            int locationx = player.getLocation().getBlockX();
            int locationy = player.getLocation().getBlockY();

            configuration.set("LocationZ", locationz);
            configuration.set("LocationX", locationx);
            configuration.set("LocationY", locationy);
            player.sendMessage(ChatColor.RED + "Tu as definie le spawn");
            config.saveConfig();
        }
        return true;
    }
}
