package shwendel.yoggies.equipment_bag;

import org.bukkit.entity.Player;
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



    }

}
