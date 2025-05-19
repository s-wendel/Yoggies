package shwendel.yoggies.archive;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;
import shwendel.yoggies.Yoggies;

import java.util.concurrent.ThreadLocalRandom;

public class TestCommand implements CommandExecutor  {

    private static final int WIND_SOUND_INTERVALS = 38;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) sender;

        Location center = player.getLocation();

        Location northSound = center.clone().add(0, 0, -5);
        Location eastSound = center.clone().add(5, 0, 0);
        Location southSound = center.clone().add(0, 0, 5);
        Location westSound = center.clone().add(-5, 0, 0);

        new BukkitRunnable() {

            int intervals = 0;

            float currentVolume = 0.025f;

            @Override
            public void run() {

                if(intervals % WIND_SOUND_INTERVALS == 0) {

                    player.stopSound(Sound.ITEM_ELYTRA_FLYING);

                    int random = ThreadLocalRandom.current().nextInt(0, 100);

                    if(random >= 35 && currentVolume >= 0.1) {

                        currentVolume -= 0.025;

                    } else if(currentVolume <= 1.5) {

                        currentVolume += 0.025;

                    }

                    Bukkit.broadcastMessage("Current volume" + currentVolume);

                    player.playSound(northSound, Sound.ITEM_ELYTRA_FLYING, currentVolume, 0.5F);
                    player.playSound(eastSound, Sound.ITEM_ELYTRA_FLYING, currentVolume, 0.5F);
                    player.playSound(southSound, Sound.ITEM_ELYTRA_FLYING, currentVolume, 0.5F);
                    player.playSound(westSound, Sound.ITEM_ELYTRA_FLYING, currentVolume, 0.5F);

                }

                for(double z = 32; z >= 23; z -= 0.25) {

                    // Generates between 0 and 1
                    double randomXOffset = ThreadLocalRandom.current().nextInt(4) * 0.25;

                    for(double x = (28 + ((32 - z) / 3.5)) - randomXOffset; x <= (31 - ((32 - z) / 3.5)) + randomXOffset; x += 0.25) {

                        player.getWorld().spawnParticle(Particle.CLOUD, new Location(player.getWorld(), x, 284.2, z), 0);

                    }

                }

                intervals++;

            }

        }.runTaskTimer(Yoggies.getInstance(), 0, 10);

        return true;
    }

}