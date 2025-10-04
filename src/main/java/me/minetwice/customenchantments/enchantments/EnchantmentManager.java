package me.minetwice.customenchantments.enchantments;

import java.util.*;

public class EnchantmentManager {
    private static final List<CustomEnchantment> ENCHANTMENTS = new ArrayList<>();

    static {
        ENCHANTMENTS.add(new FireDash());
        ENCHANTMENTS.add(new LightningStrike());
        // Yahan par 28 aur enchantments add karni hain (next steps me templates dunga)
    }

    public static CustomEnchantment getRandomEnchantment(Set<CustomEnchantment> exclude) {
        List<CustomEnchantment> available = new ArrayList<>(ENCHANTMENTS);
        available.removeAll(exclude);
        if (available.isEmpty()) return null;
        return available.get(new Random().nextInt(available.size()));
    }

    public static List<CustomEnchantment> getAllEnchantments() {
        return Collections.unmodifiableList(ENCHANTMENTS);
    }
}
