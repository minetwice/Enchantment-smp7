package me.minetwice.customenchantments;

import org.bukkit.plugin.java.JavaPlugin;

public class CustomEnchantments extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("CustomEnchantments Plugin Enabled!");
        // Yahan se next steps me logic add karenge
    }

    @Override
    public void onDisable() {
        getLogger().info("CustomEnchantments Plugin Disabled!");
    }
}
