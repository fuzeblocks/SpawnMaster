package fr.fuzeblocks.spawnmaster;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TploginCommand implements CommandExecutor {
    private SpawnMaster config;
    public TploginCommand(SpawnMaster config) {
        this.config = config;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (!(sender instanceof Player)) {
            sender.sendMessage("Seule un joueur peut definir le setspawn");
        }
        if (!player.hasPermission("SpawnMaster.tponlogin")) {
            player.sendMessage(ChatColor.RED + "Desoler mais tu n'as pas la permission !");
        } else if (player.hasPermission("SpawnMaster.tponlogin")) {
            if (args.length == 1 && args[0].equals("true")) {
                config.getConfig().set("Tponspawn", true);
                player.sendMessage(ChatColor.GREEN + "Teleportation a l apparition activee !");
            }

            if (args.length == 1 && args[0].equals("false")) {
                config.getConfig().set("Tponspawn", false);
                player.sendMessage(ChatColor.GREEN + "Teleportation a l apparition desactivee !");
            }

        }
        config.saveConfig();
        return true;

    }
}
