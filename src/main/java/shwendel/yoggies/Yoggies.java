package shwendel.yoggies;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import shwendel.yoggies.item.listener.AbilityItemRightClickListener;

public final class Yoggies extends JavaPlugin {

    // The amount of vanilla equipment slots an entity can have (Armor (right now), not the equipment bag equipment)
    public static int VANILLA_EQUIPMENT_SLOTS_SIZE = 4;

    private static Yoggies instance;

    @Override
    public void onEnable() {

        instance = this;

        getCommand("test").setExecutor(new TestCommand());

        EventManager.load();

    }

    @Override
    public void onDisable() {

        instance = null;

    }

    public static Yoggies getInstance() {
        return instance;
    }

}
