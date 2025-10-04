package me.minetwice.customenchantments.data;

import me.minetwice.customenchantments.enchantments.CustomEnchantment;

import java.util.*;

public class PlayerEnchantments {
    private final Map<UUID, List<CustomEnchantment>> playerEnchants = new HashMap<>();

    public List<CustomEnchantment> getEnchantments(UUID uuid) {
        return playerEnchants.getOrDefault(uuid, new ArrayList<>());
    }

    public void addEnchantment(UUID uuid, CustomEnchantment enchantment) {
        List<CustomEnchantment> list = playerEnchants.computeIfAbsent(uuid, k -> new ArrayList<>());
        if (list.size() < 3 && !list.contains(enchantment)) {
            list.add(enchantment);
        }
    }

    public void removeEnchantment(UUID uuid, CustomEnchantment enchantment) {
        List<CustomEnchantment> list = playerEnchants.get(uuid);
        if (list != null) list.remove(enchantment);
    }
}
