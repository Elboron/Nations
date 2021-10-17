package nationsatwar.nationsatwar;

import nationsatwar.nationsatwar.commands.FactionCommandHandler;
import nationsatwar.nationsatwar.events.EventHandler;
import nationsatwar.nationsatwar.factions.FactionsContainer;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Nationsatwar extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        pluginInstance = this;
        logger = getLogger();

        FactionsContainer.loadFactions();
        KeyContainer.initKeys();
        OnlinePlayer.addOnlinePlayers();

        getServer().getPluginManager().registerEvents(new EventHandler(), this);
        this.getCommand("faction").setExecutor(new FactionCommandHandler());
    }

    public static Nationsatwar getPluginInstance() {
        return pluginInstance;
    }

    public static Logger getPluginLogger() {
        return logger;
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private static Nationsatwar pluginInstance;
    private static Logger logger;
}
