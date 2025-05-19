package shwendel.yoggies.equipment_bag.gui;

import mc.obliviate.inventory.Gui;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import shwendel.yoggies.item.YoggiesEquipmentItem;
import shwendel.yoggies.item.YoggiesItemManager;
import shwendel.yoggies.profile.ProfileManager;
import shwendel.yoggies.profile.ProfileMemory;
import shwendel.yoggies.util.ItemUtil;

public class EquipmentBagGUI extends Gui {

    public static final String EQUIPMENT_BAG_GUI_ID = "equipment_bag";
    public static final String EQUIPMENT_BAG_GUI_TITLE = "Equipment Bag";
    public static final int EQUIPMENT_BAG_GUI_ROWS = 3;

    private final int slots;

    private ProfileMemory profile;

    public EquipmentBagGUI(@NotNull Player player) {

        super(player, EQUIPMENT_BAG_GUI_ID, EQUIPMENT_BAG_GUI_TITLE, EQUIPMENT_BAG_GUI_ROWS);

        this.profile = ProfileManager.getProfile(player);
        this.slots = EQUIPMENT_BAG_GUI_ROWS * 9;

    }

    @Override
    public boolean onClick(InventoryClickEvent event) {

        ItemStack cursor = event.getCursor();

        if(event.getRawSlot() < slots || (event.getRawSlot() > slots && event.getClick().name().contains("SHIFT"))) {

            if(!ItemUtil.isItem(cursor) || !(YoggiesItemManager.getItem(cursor) instanceof YoggiesEquipmentItem)) {

                // Magical sound
                playAwesomeMagicalBarrierSound(player);

                return false;

            }

        }


        return true;
    }

    @Override
    public boolean onDrag(InventoryDragEvent event) {

        ItemStack cursor = event.getCursor();

        if(cursor == null) {
            return false;
        }

        int amountRefundedToCursor = 0;

        for(int draggedSlot : event.getRawSlots()) {

            if(draggedSlot < slots) {

                event.getInventory().setItem(draggedSlot, null);

                amountRefundedToCursor++;

            }

        }

        if(amountRefundedToCursor > 0) {

            ItemStack newCursor = new ItemStack(cursor);

            newCursor.setAmount(event.getCursor().getAmount() + amountRefundedToCursor);

            event.setCursor(newCursor);

        }

        return true;
    }

    @Override
    public void onOpen(InventoryOpenEvent event) {

        // TODO Load all equipment

        //block.shroomlight.break

    }

    @Override
    public void onClose(InventoryCloseEvent event) {



    }

    private void playAwesomeMagicalBarrierSound(Player player) {

        player.playSound(player.getLocation(), Sound.BLOCK_SHROOMLIGHT_BREAK, 1f, 2f);

    }

}
