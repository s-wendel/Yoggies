package shwendel.yoggies.equipment_bag;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import shwendel.yoggies.equipment_bag.gui.EquipmentBagGUI;
import shwendel.yoggies.item.YoggiesEquipmentItem;
import shwendel.yoggies.item.YoggiesEquipmentItemMemory;

import java.util.ArrayList;
import java.util.List;

public class EquipmentBag {

    private final List<YoggiesEquipmentItemMemory> equipment;

    public EquipmentBag() {
        this(new ArrayList<>());
    }

    public EquipmentBag(List<YoggiesEquipmentItemMemory> equipment) {
        this.equipment = equipment;
    }

    public List<YoggiesEquipmentItemMemory> getEquipment() {
        return equipment;
    }

    public void openEquipmentGUI(Player player) {

        player.playSound(player.getLocation(), Sound.ITEM_BUNDLE_INSERT, 1f, 1f);

        new EquipmentBagGUI(player).open();

    }

}
