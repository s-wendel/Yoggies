package shwendel.yoggies.item.listener;

import net.minecraft.world.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import shwendel.yoggies.item.*;
import shwendel.yoggies.profile.ProfileManager;
import shwendel.yoggies.profile.ProfileMemory;

import java.util.Map;

public class AbilityItemRightClickListener implements Listener {

    @EventHandler
    public void playerInteractEvent(PlayerInteractEvent event) {

        Player player = event.getPlayer();

        ProfileMemory profileMemory = ProfileManager.getProfile(player);

        // Loop through all equipment

        // Main hand
        // Off hand ?
        // Armor?
        for(Map.Entry<YoggiesItemMemory, YoggiesEquipableItemType> equippedItem : profileMemory.getAllEquippedItems().entrySet()) {

            YoggiesItem yoggiesItem = equippedItem.getKey().getItem();

            if(yoggiesItem instanceof YoggiesAbilityItem) {

                ((YoggiesAbilityItem) yoggiesItem).runAbility((Entity) player, YoggiesAbilityType.RIGHT_CLICK);

            }

        }

    }

}
