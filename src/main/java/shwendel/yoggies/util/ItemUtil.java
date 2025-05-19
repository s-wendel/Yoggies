package shwendel.yoggies.util;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ItemUtil {

    private ItemUtil() {}

    /**
     * Returns whether or not an ItemStack is an item. I think empty items are always AIR - I could be wrong,
     * but this should future proof if they ever change it to be null instead
     * @param item
     * @return
     */
    public static boolean isItem(ItemStack item) {
        return item != null && item.getType() != Material.AIR;
    }

}
