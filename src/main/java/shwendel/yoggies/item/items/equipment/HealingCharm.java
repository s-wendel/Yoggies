package shwendel.yoggies.item.items.equipment;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;
import shwendel.yoggies.item.YoggiesAbilityType;
import shwendel.yoggies.item.YoggiesEquipmentItem;
import shwendel.yoggies.item.YoggiesItemID;
import shwendel.yoggies.util.SkullUtil;

public class HealingCharm extends YoggiesEquipmentItem {

    @Override
    public String getName() {
        return "Healing Charm";
    }

    @Override
    public String getDisplayName() {
        return ChatColor.WHITE + "Healing Charm";
    }

    @Override
    public YoggiesItemID getItemID() {
        return YoggiesItemID.HEALING_CHARM;
    }

    @Override
    public ItemStack getMinecraftMaterial() {
        return SkullUtil.getSkull("eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZmI1MDU1YmNjYmVhZDExNWQ4ZWE4NDFjMzhhMjM4NWY1ZTNiZTQyNDdlNTI0YmRlYjAzNWYyNjFhOGY3ZWE5YSJ9fX0=");
    }

    @Override
    public void runAbility(Entity user, YoggiesAbilityType abilityTypeUsed) {

    }

}
