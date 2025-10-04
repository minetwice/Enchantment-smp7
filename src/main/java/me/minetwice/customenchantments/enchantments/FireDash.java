package me.minetwice.customenchantments.enchantments;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FireDash implements CustomEnchantment {
    @Override
    public String getName() { return "Fire Dash"; }

    @Override
    public String getDescription() { return "Dash forward with a trail of fire!"; }

    @Override
    public void activate(Player player, PlayerInteractEvent event) {
        player.setVelocity(player.getLocation().getDirection().multiply(2));
        player.getWorld().spawnParticle(Particle.FLAME, player.getLocation(), 100, 1, 1, 1, 0.1);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_BLAZE_SHOOT, 1, 1);
    }

    @Override
    public String getIconMaterial() { return "BLAZE_POWDER"; }
}
