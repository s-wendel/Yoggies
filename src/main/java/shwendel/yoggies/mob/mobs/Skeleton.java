package shwendel.yoggies.mob.mobs;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.animal.frog.Frog;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.pathfinder.PathFinder;
import org.bukkit.ChatColor;
import org.bukkit.entity.BlockDisplay;
import shwendel.yoggies.mob.YoggiesMob;
import shwendel.yoggies.mob.YoggiesMobID;

public class Skeleton extends net.minecraft.world.entity.monster.Skeleton implements YoggiesMob {

    public Skeleton(EntityType<? extends net.minecraft.world.entity.monster.Skeleton> entitytypes, Level world) {

        super(entitytypes, world);

        this.goalSelector.getAvailableGoals().clear();

        this.goalSelector.addGoal(0, new MeleeAttackGoal(this, 0.5, false));

    }

    @Override
    public String getMobName() {
        return "Skeleton";
    }

    @Override
    public String getMobDisplayName() {
        return ChatColor.WHITE + "Skeleton";
    }

    @Override
    public YoggiesMobID getID() {
        return YoggiesMobID.SKELETON;
    }

    @Override
    public org.bukkit.entity.EntityType getEntityType() {
        return org.bukkit.entity.EntityType.SKELETON;
    }

}
