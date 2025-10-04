package me.minetwice.customenchantments.enchantments;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public interface CustomEnchantment {
    String getName();
    String getDescription();
    void activate(Player player, PlayerInteractEvent event);
    String getIconMaterial(); // For spinner GUI
}
