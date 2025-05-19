package shwendel.yoggies;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Cow;
import net.minecraft.world.item.BundleItem;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_21_R3.CraftWorld;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BundleMeta;
import org.jetbrains.annotations.NotNull;
import shwendel.yoggies.item.gui.AllItemsGUI;
import shwendel.yoggies.mob.mobs.AwesomeChicken;
import shwendel.yoggies.mob.mobs.Skeleton;

import java.util.ArrayList;
import java.util.List;

public class TestCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {

        Player player = (Player) sender;

        if(!player.hasPermission("admin")) {

            player.sendMessage(ChatColor.RED + "No banks!");

        } else if(args.length == 0) {

            player.sendMessage(ChatColor.WHITE + "/test all_items");
            player.sendMessage(ChatColor.WHITE + "/test new_feature");

        } else {

            switch(args[0].toLowerCase()) {

                case "all_items":

                    new AllItemsGUI(player).open();

                    break;

                case "new_feature":

                    CraftWorld world = (CraftWorld) player.getWorld();

                    AwesomeChicken skeleton = new AwesomeChicken(EntityType.CHICKEN, world.getHandle());

                    skeleton.spawn(skeleton, player.getLocation());

                    break;

                default:

                    break;

            }

        }

        return true;
    }

}
