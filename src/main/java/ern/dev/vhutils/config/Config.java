package ern.dev.vhutils.config;

import ern.dev.vhutils.VHUtils;

import net.kyori.adventure.text.Component;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.logging.Level;

public class Config {

    private FileConfiguration fc;

    private static final int config_version = 1;

    public static boolean debug = false;

    private static Map<String, Component> translations = new HashMap<>();


    public static boolean disableStands = true;

    public Config() {
        this.fc = VHUtils.plugin.getConfig();
        load();
    }

    public void load() {
        int version = this.fc.contains("version") ? this.fc.getInt("version") : 0;
        if (version < config_version)
            upgrade();
        if (this.fc.contains("debug"))
            debug = this.fc.getBoolean("debug");
        if (this.fc.contains("disablestands")){
            disableStands = this.fc.getBoolean("disablestands");
        }
        initMessages();
    }

    private void upgrade() {

        VHUtils.logger.log(Level.WARNING, "Upgrading config file to latest version ("
                + this.fc.getInt("version") + " --> " + config_version + ")");

        this.fc.options().copyDefaults(true);
        this.fc.set("version", config_version);

        VHUtils.plugin.saveConfig();
    }

    public void reload() {

        if (debug)
            VHUtils.logger.info("Reloading configuration");

        VHUtils.plugin.reloadConfig();
        this.fc = VHUtils.plugin.getConfig();
        load();
    }

    private void initMessages() {
        for (String key : Objects.requireNonNull(fc.getConfigurationSection("messages")).getKeys(false)) {
            translations.put(key, VHUtils.builder.finalComp(Objects.requireNonNull(fc.getString("messages." + key))));
        }
    }
    public Component tl(String s) {
        return translations.get(s);
    }
}
