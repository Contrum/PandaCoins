package dev.panda.coins.profile;

import com.google.common.collect.Maps;
import lombok.Getter;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 26-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@Getter
public class ProfileManager {

    private final Map<UUID, Profile> profiles;

    public ProfileManager() {
        this.profiles = Maps.newHashMap();
    }

    public Profile getProfile(UUID uuid) {
        return profiles.get(uuid);
    }

    public Profile getOrCreateProfile(UUID uuid) {
        if (profiles.containsKey(uuid)) {
            return profiles.get(uuid);
        }
        else {
            Profile profile = new Profile(uuid);
            profiles.put(uuid, profile);
            return profile;
        }
    }

    public void saveAll() {
        for (Profile profile : profiles.values()) {
            profile.save(false, false);
        }
    }
}
