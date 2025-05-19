package shwendel.yoggies.item;

import org.bukkit.entity.Entity;
import org.bukkit.inventory.ItemStack;

public abstract class YoggiesAbilityItem extends YoggiesItem {

    /**
     * Ran when an ability is used by an entity
     * @param user The entity who used the ability
     * @param abilityTypeUsed The type of ability/ability trigger used e.g. RIGHT_CLICK or damaging another entity
     */
    public abstract void runAbility(Entity user, YoggiesAbilityType abilityTypeUsed);

}
