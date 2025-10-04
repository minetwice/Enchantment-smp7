package me.minetwice.customenchantments.enchantments;

import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class LightningStrike implements CustomEnchantment {
    @Override
    public String getName() { return "Lightning Strike"; }

    @Override
    public String getDescription() { return "Summon lightning where you look!"; }

    @Override
    public void activate(Player player, PlayerInteractEvent event) {
        player.getWorld().strikeLightning(player.getTargetBlock(null, 30).getLocation());
        player.getWorld().spawnParticle(Particle.CRIT_MAGIC, player.getLocation(), 60, 1, 1, 1, 0.2);
        player.getWorld().playSound(player.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 1, 1);
    }

    @Override
    public String getIconMaterial() { return "AMETHYST_SHARD"; }
}
