package shwendel.yoggies.itembuilder;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import shwendel.yoggies.Yoggies;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

    private final ItemStack item;
    private final ItemMeta itemMeta;

    public ItemBuilder(ItemStack item) {

        this.item = item;
        this.itemMeta = item.getItemMeta();

    }

    public ItemBuilder(Material material) {

        this.item = new ItemStack(material);
        this.itemMeta = item.getItemMeta();

    }

    public ItemBuilder setName(String name) {

        itemMeta.setDisplayName(name);

        return this;
    }

    public String getName() {
        return itemMeta.getDisplayName();
    }

    public ItemBuilder addLore(String line) {

        List<String> lines = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();

        lines.add(ChatColor.translateAlternateColorCodes('&', line));

        itemMeta.setLore(lines);

        return this;
    }

    public ItemBuilder addLore(List<String> list) {

        assert(list != null);

        List<String> lines = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();

        lines.addAll(list);

        itemMeta.setLore(lines);

        return this;
    }

    public ItemBuilder setLore(int slot, String line) {

        List<String> lines = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();

        lines.set(slot, line);

        itemMeta.setLore(lines);

        return this;
    }

    public ItemBuilder setLore(String... lines) {

        List<String> newLines = itemMeta.hasLore() ? itemMeta.getLore() : new ArrayList<>();

        for(String line : lines) {

            newLines.add(line);

        }

        itemMeta.setLore(newLines);

        return this;
    }

    public ItemBuilder addEnchantment(Enchantment enchant, int level) {

        item.addUnsafeEnchantment(enchant, level);

        return this;
    }

    public ItemBuilder removeEnchantment(Enchantment enchant) {

        item.removeEnchantment(enchant);

        return this;
    }

    public ItemBuilder addFlag(ItemFlag flag) {

        itemMeta.addItemFlags(flag);

        return this;
    }

    public ItemBuilder setAmount(int amount) {

        item.setAmount(amount);

        return this;
    }

    public ItemBuilder setUnbreakable(boolean unbreakable) {

        itemMeta.setUnbreakable(unbreakable);

        return this;
    }

    public ItemStack toItemStack() {

        item.setItemMeta(itemMeta);

        return item;
    }

    public <T> void setItemKey(String key, PersistentDataType persistentDataType, T object) {

        assert(object != null);

        NamespacedKey namespacedKey = new NamespacedKey(Yoggies.getInstance(), key);

        itemMeta.getPersistentDataContainer().set(namespacedKey, persistentDataType, object);

        item.setItemMeta(itemMeta);


    }

    public <T> T getItemValue(String key, PersistentDataType persistentDataType) {

        NamespacedKey namespacedKey = new NamespacedKey(Yoggies.getInstance(), key);

        ItemMeta itemMeta = item.getItemMeta();
        PersistentDataContainer container = itemMeta.getPersistentDataContainer();

        T value = null;

        if(container.has(namespacedKey, persistentDataType)) {

            value = (T) container.get(namespacedKey, persistentDataType);

        }

        return value;
    }

}
