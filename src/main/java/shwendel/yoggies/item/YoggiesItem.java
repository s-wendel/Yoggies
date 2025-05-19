package shwendel.yoggies.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public abstract class YoggiesItem {

    public abstract String getName();
    public abstract YoggiesItemID getItemID();
    /**
     * Returns an ItemStack representing the material of the item without any customization e.g. the display name or lore
     * @return an ItemStack representing the material of the item without any customization e.g. the display name or lore
     */
    public abstract ItemStack getMinecraftMaterial();

    /**
     * Returns the actual item ingame with customization / NBT e.g. with the display name and lore
     * @return The actual item ingame with customization / NBT e.g. with the display name and lore
     */
    public ItemStack getItem() {
        // TODO
        return null;
    }

}
