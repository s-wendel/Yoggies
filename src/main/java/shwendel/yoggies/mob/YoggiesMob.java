package shwendel.yoggies.mob;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import shwendel.yoggies.Yoggies;
import shwendel.yoggies.item.YoggiesItem;

public interface YoggiesMob {

    String getMobName();
    String getMobDisplayName();
    YoggiesMobID getID();
    EntityType getEntityType();

    default YoggiesItem getMainHand() {
        return null;
    }

    default YoggiesItem getOffHand() {
        return null;
    }

    default YoggiesItem getHelmet() {
        return null;
    }

    default YoggiesItem getChestplate() {
        return null;
    }

    default YoggiesItem getLeggings() {
        return null;
    }

    default YoggiesItem getBoots() {
        return null;
    }

    default YoggiesItem[] getEquipment() {
        // This is the ordering for Spigot, I think ... We'll see...
        return new YoggiesItem[] { getBoots(), getLeggings(), getChestplate(), getHelmet() };
    }

    //public abstract float getWalkSpeed();
    //public float getFlySpeed();
    //public abstract YoggiesItem

    default void spawn(net.minecraft.world.entity.Entity nmsEntity, Location location) {

        // Set nmsEntity's location
        nmsEntity.setPos(location.getX(), location.getY(), location.getZ());

        CraftWorld craftWorld = (CraftWorld) location.getWorld();

        craftWorld.getHandle().addFreshEntity(nmsEntity);

        Entity bukkitEntity = nmsEntity.getBukkitEntity();

        bukkitEntity.setCustomNameVisible(true);
        bukkitEntity.setCustomName(getMobDisplayName());

        // NMS LivingEntity
        if(bukkitEntity instanceof LivingEntity) {

            LivingEntity livingEntity = (LivingEntity) bukkitEntity;

            YoggiesItem[] yoggiesItemEquipment = getEquipment();

            // You never know if they add a new equipment slot
            ItemStack[] equipment = new ItemStack[Yoggies.VANILLA_EQUIPMENT_SLOTS_SIZE];

            for(int i = 0; i < yoggiesItemEquipment.length; i++) {

                equipment[i] = yoggiesItemEquipment[i].getMinecraftMaterial();

            }

            livingEntity.getEquipment().setArmorContents(equipment);

        }

    }

}
