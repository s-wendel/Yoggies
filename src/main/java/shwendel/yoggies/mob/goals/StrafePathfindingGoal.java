package shwendel.yoggies.mob.goals;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.world.entity.ai.goal.target.TargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.phys.AABB;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.entity.EntityTargetEvent;

import javax.annotation.Nullable;

public class StrafePathfindingGoal<T extends LivingEntity> extends TargetGoal {

    // The distance away the mob retreats from the target if the target gets too close
    private static int RETREAT_DISTANCE = 5;
    // If the target is this amount of distance from the mob, retreats away to the retreat distance
    private static int START_RETREATING_DISTANCE = 3;
    // The distance
    private static int NAVIGATE_TOWARDS_TARGET_DISTANCE = 5;

    protected LivingEntity target;
    protected final Class<T> targetType;
    protected TargetingConditions targetConditions;
    protected double speed;

    public StrafePathfindingGoal(PathfinderMob pathfinderMob, boolean mustSee, boolean mustReach, Class<T> targetType, double speed) {
        super(pathfinderMob, mustSee, mustReach);

        this.targetType = targetType;
        this.targetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector(null);
        this.speed = speed;

    }

    @Override
    public void start() {

        this.mob.setTarget(this.target, this.target instanceof ServerPlayer ? EntityTargetEvent.TargetReason.CLOSEST_PLAYER : EntityTargetEvent.TargetReason.CLOSEST_ENTITY, true);

        super.start();

    }

    @Override
    public void tick() {

        double distance = mob.getBukkitEntity().getLocation().distance(target.getBukkitEntity().getLocation());

        if(distance > NAVIGATE_TOWARDS_TARGET_DISTANCE) {

            this.mob.getNavigation().moveTo(this.target.getX(), this.target.getY(), this.target.getZ(), speed);

        } else if(distance <= START_RETREATING_DISTANCE) {

            // This always baffled me when I was younger, if you want help understanding this
            // make a forum post on spigot and @ me : https://www.spigotmc.org/members/swendel.502629/

            double originX = target.getX();
            double originZ = target.getZ();

            double deltaX = mob.getX() - originX;
            double deltaZ = mob.getZ() - originZ;

            double theta = Math.atan2(deltaZ, deltaX);

            double hypotenuse = RETREAT_DISTANCE;

            double newX = originX + hypotenuse * Math.cos(theta);
            double newZ = originZ + hypotenuse * Math.sin(theta);

            double newY = target.getY();

            this.mob.getNavigation().moveTo(newX, newY, newZ, speed);

        } else {

            // Move in a circle
            this.mob.getNavigation().stop();

        }

    }

    protected AABB getTargetSearchArea(double d0) {
        return this.mob.getBoundingBox().inflate(d0, d0, d0);
    }

    private TargetingConditions getTargetConditions() {
        return this.targetConditions.range(this.getFollowDistance());
    }

    protected void findTarget() {

        ServerLevel worldserver = getServerLevel(this.mob);
        TargetingConditions targetingConditions = getTargetConditions();

        if (this.targetType != Player.class && this.targetType != ServerPlayer.class) {
            this.target = worldserver.getNearestEntity(this.mob.level().getEntitiesOfClass(this.targetType, this.getTargetSearchArea(this.getFollowDistance()), (entityliving) -> {
                return true;
            }), targetingConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        } else {
            this.target = worldserver.getNearestPlayer(targetingConditions, this.mob, this.mob.getX(), this.mob.getEyeY(), this.mob.getZ());
        }

    }

    @Override
    public boolean canUse() {
        this.findTarget();
        return this.target != null;
    }

}