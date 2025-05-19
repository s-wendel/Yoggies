package shwendel.yoggies.profile;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import shwendel.yoggies.equipment_bag.EquipmentBag;
import shwendel.yoggies.item.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileMemory {

    private UUID uuid;
    private EquipmentBag equipmentBag;

    public ProfileMemory(UUID uuid, EquipmentBag equipmentBag) {
        this.uuid = uuid;
        this.equipmentBag = equipmentBag;
    }

    public UUID getUUID() {
        return uuid;
    }

    public EquipmentBag getEquipmentBag() {
        return equipmentBag;
    }

    /**
     * Returns a map of all currently equipped items' memory: armor, mainhand item,
     * offhand item, all equipment bag equipment. The key in the map is the item equipped
     * and the value is the type of type of equipped item: armor, mainhand item, offhand, etc...
     * @return A map of all currently equipped items
     */
    public Map<YoggiesItemMemory, YoggiesEquipableItemType> getAllEquippedItems() {

        Player player = Bukkit.getPlayer(uuid);

        Map<YoggiesItemMemory, YoggiesEquipableItemType> getAllEquippedItems = new HashMap<>();

        // TODO Armor + mainhand + offhand loading data
        System.out.println(player.getInventory().getItemInMainHand());

        // TODO Load specific memory for ability items or equipment

        YoggiesItem mainHandItem = YoggiesItemManager.getItem(player.getInventory().getItemInMainHand());

        if(YoggiesItemManager.isItem(mainHandItem)) {

            YoggiesItemMemory mainHandItemMemory = new YoggiesItemMemory(mainHandItem);

            getAllEquippedItems.put(mainHandItemMemory, YoggiesEquipableItemType.MAIN_HAND);

        }

        for(YoggiesEquipmentItemMemory equipmentItemMemory : getEquipmentBag().getEquipment()) {

            getAllEquippedItems.put(equipmentItemMemory, YoggiesEquipableItemType.EQUIPMENT);

        }

        return getAllEquippedItems;
    }

}
