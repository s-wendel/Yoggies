package shwendel.yoggies.item;

import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;
import shwendel.yoggies.item.items.ability_items.EquipmentBagItem;
import shwendel.yoggies.item.items.equipment.HealingCharm;
import shwendel.yoggies.itembuilder.ItemBuilder;

import java.util.HashMap;
import java.util.Map;

public class YoggiesItemManager {

    private static final Map<YoggiesItemID, YoggiesItem> ITEMS = new HashMap<>();

    static {

        ITEMS.put(YoggiesItemID.EQUIPMENT_BAG, new EquipmentBagItem());
        ITEMS.put(YoggiesItemID.HEALING_CHARM, new HealingCharm());

    }

    /**
     * Returns whether or not an item is a valid item - for now, if it's null
     * @return whether or not an item is a valid item - for now, if it's null
     */
    public static boolean isItem(YoggiesItem item) {
        return item != null;
    }

    /**
     * Returns a clone of a map containing all the items: the key of the map is the YoggiesItemID of an item,
     * and the value is the YoggiesItem that uses that item ID
     * @return A clone of a map containing all the items
     */
    public static Map<YoggiesItemID, YoggiesItem> getAllItems() {
        return new HashMap<>(ITEMS);
    }

    public static YoggiesItem getItem(ItemStack item) {

        ItemBuilder itemBuilder = new ItemBuilder(item);

        String itemIDString = itemBuilder.getItemValue(YoggiesItem.PERSISTENT_DATA_CONTAINER_ITEM_KEY, PersistentDataType.STRING);

        YoggiesItemID itemID;

        try {

            itemID = YoggiesItemID.valueOf(itemIDString);

        } catch(Exception exception) {

            itemID = null;

        }

        return getItem(itemID);
    }

    public static YoggiesItem getItem(YoggiesItemID itemID) {
        return itemID == null ? null : ITEMS.getOrDefault(itemID, null);
    }

}
