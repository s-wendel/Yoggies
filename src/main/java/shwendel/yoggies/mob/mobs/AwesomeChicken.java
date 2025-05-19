package shwendel.yoggies.mob.mobs;

import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.Wolf;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import shwendel.yoggies.mob.YoggiesMob;
import shwendel.yoggies.mob.YoggiesMobID;
import shwendel.yoggies.mob.goals.StrafePathfindingGoal;

public class AwesomeChicken extends Chicken implements YoggiesMob {

    public AwesomeChicken(net.minecraft.world.entity.EntityType<? extends Chicken> entitytypes, Level world) {

        super(entitytypes, world);

        this.goalSelector.getAvailableGoals().clear();

        this.targetSelector.addGoal(1, new StrafePathfindingGoal(this, false, false, Player.class, 0.85));

        //this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.0, true));
        //this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));

    }

    @Override
    public String getMobName() {
        return "Awesome Chicken";
    }

    @Override
    public String getMobDisplayName() {
        return ChatColor.GOLD + "Awesome Chicken";
    }

    @Override
    public YoggiesMobID getID() {
        return YoggiesMobID.AWESOME_CHICKEN;
    }

    @Override
    public EntityType getEntityType() {
        return EntityType.CHICKEN;
    }

}
