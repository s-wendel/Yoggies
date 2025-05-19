package shwendel.yoggies.item;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import shwendel.yoggies.itembuilder.ItemBuilder;

public abstract class YoggiesItem {

    public static String PERSISTENT_DATA_CONTAINER_ITEM_KEY = "item";

    public abstract String getName();
    public abstract String getDisplayName();
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

        ItemBuilder itemBuilder = new ItemBuilder(getMinecraftMaterial());

        itemBuilder.setItemKey(YoggiesItem.PERSISTENT_DATA_CONTAINER_ITEM_KEY, PersistentDataType.STRING, getItemID().toString());

        itemBuilder.setName(getName());

        return itemBuilder.toItemStack();
    }

}
