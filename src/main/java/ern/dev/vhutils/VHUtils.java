package ern.dev.vhutils;

import ern.dev.vhutils.commands.VHUtilsCommand;
import ern.dev.vhutils.config.Config;
import ern.dev.vhutils.listeners.PlayerListeners;
import ern.dev.vhutils.messages.Builder;

import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class VHUtils extends JavaPlugin {

    public static VHUtils plugin;

    public static Builder builder;

    public static Logger logger;

    public static Config config;

    @Override
    public void onEnable() {

        plugin = this;
        logger = getLogger();
        builder = new Builder();

        logger.log(Level.INFO, "Loading resources...");
        config = new Config();
        logger.log(Level.INFO, "Loaded config");

        getServer().getPluginManager().registerEvents((Listener)new PlayerListeners(), (Plugin)plugin);
        Objects.requireNonNull(plugin.getCommand("vhutils")).setExecutor((CommandExecutor) new VHUtilsCommand());


    }

    @Override
    public void onDisable() {

    }

    public Config returnConfig(){
        return config;
    }
}
