package fr.fuzeblocks.spawnmaster;

import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnMaster extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info("SpawnMaster vient de s'allumer !");
        getCommand("spawn").setExecutor(new SpawnCommand(this));
        getCommand("setspawn").setExecutor(new SetspawnCommand(this));
        getCommand("tponlogin").setExecutor(new TploginCommand(this) );
        getServer().getPluginManager().registerEvents(new SpawnConnectionEvent(this), this);
        // Plugin startup logic

    }

    @Override
    public void onDisable() {
        this.saveConfig();
        // Plugin shutdown logic
    }
}
