package me.minetwice.customenchantments.listener;

import me.minetwice.customenchantments.CustomEnchantments;
import me.minetwice.customenchantments.data.PlayerEnchantments;
import me.minetwice.customenchantments.enchantments.CustomEnchantment;
import me.minetwice.customenchantments.enchantments.EnchantmentManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class FirstJoinListener implements Listener {
    private final Set<UUID> joined = new HashSet<>();
    private final PlayerEnchantments playerEnchantments;

    public FirstJoinListener(PlayerEnchantments playerEnchantments) {
        this.playerEnchantments = playerEnchantments;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (joined.contains(player.getUniqueId())) return;

        CustomEnchantment enchant = EnchantmentManager.getRandomEnchantment(new HashSet<>(playerEnchantments.getEnchantments(player.getUniqueId())));
        if (enchant != null) {
            playerEnchantments.addEnchantment(player.getUniqueId(), enchant);

            // Give enchanted item in first slot
            ItemStack item = new ItemStack(Material.valueOf(enchant.getIconMaterial()));
            ItemMeta meta = item.getItemMeta();
            meta.setDisplayName("§6" + enchant.getName());
            List<String> lore = new ArrayList<>();
            lore.add("§7" + enchant.getDescription());
            meta.setLore(lore);
            item.setItemMeta(meta);

            player.getInventory().setItem(0, item);
            player.sendMessage("§aYou received a special power: §e" + enchant.getName() + "§a!");
            // Play sound, show particles, etc.
        }
        joined.add(player.getUniqueId());
    }
}
