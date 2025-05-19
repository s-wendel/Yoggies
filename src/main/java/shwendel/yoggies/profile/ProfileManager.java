package shwendel.yoggies.profile;

import org.bukkit.entity.Player;
import shwendel.yoggies.equipment_bag.EquipmentBag;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.UUID;

public class ProfileManager {

    private ProfileManager() {}

    private static final Map<UUID, ProfileMemory> PROFILES = new HashMap<>();

    public static ProfileMemory getProfile(UUID uuid) {

        if(!PROFILES.containsKey(uuid)) {

            PROFILES.put(uuid, new ProfileMemory(uuid, new EquipmentBag()));

            //PROFILES.put(uuid, new ProfileMemory(uuid, null, new HashSet<>(), new HashSet<>(), new HashMap<>(), null, null));

            //PROFILES.get(uuid).resetCoreNodes();

        }

        return PROFILES.get(uuid);
    }

    public static ProfileMemory getProfile(Player player) {
        return getProfile(player.getUniqueId());
    }

    private static void loadProfile(UUID uuid) {

    }

    public static void saveProfile(UUID uuid) {

    }

    private static void unloadProfile(UUID uuid) {

    }

}