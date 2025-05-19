package shwendel.yoggies.item.gui;

import mc.obliviate.inventory.Gui;
import mc.obliviate.inventory.Icon;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.jetbrains.annotations.NotNull;
import shwendel.yoggies.item.YoggiesItem;
import shwendel.yoggies.item.YoggiesItemID;
import shwendel.yoggies.item.YoggiesItemManager;
import shwendel.yoggies.item.YoggiesItemMemory;

import java.util.Map;

public class AllItemsGUI extends Gui {

    public static final String ALL_ITEMS_GUI_NAME = "All Items";
    public static final String ALL_ITEMS_GUI_ID = "all_items_gui";
    public static final int ALL_ITEMS_GUI_ROWS = 6;

    public AllItemsGUI(@NotNull Player player) {
        super(player, ALL_ITEMS_GUI_ID, ALL_ITEMS_GUI_NAME, ALL_ITEMS_GUI_ROWS);
    }

    @Override
    public boolean onClick(InventoryClickEvent event) {
        return true;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {

        for(Map.Entry<YoggiesItemID, YoggiesItem> item : YoggiesItemManager.getAllItems().entrySet()) {

            addItem(item.getValue().getItem());

        }

    }

}
