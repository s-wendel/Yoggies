package shwendel.yoggies;

import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import shwendel.yoggies.item.listener.AbilityItemRightClickListener;

public class EventManager {

    private static final Listener[] LISTENERS = new Listener[] {
            new AbilityItemRightClickListener(),
    };

    public static void load() {

        Yoggies mainClass = Yoggies.getInstance();

        PluginManager pluginManager = mainClass.getServer().getPluginManager();

        for(Listener listener : LISTENERS) {

            pluginManager.registerEvents(listener, mainClass);

        }

    }

}
