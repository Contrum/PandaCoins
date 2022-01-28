package dev.panda.coins;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.profile.Profile;
import lombok.Getter;

import java.util.UUID;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 26-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class PandaCoinsAPI {

    @Getter
    private static PandaCoinsAPI instance;

    private PandaCoinsAPI() {
        instance = this;
    }

    public int getCoins(UUID uuid) {
        Profile profile = ModuleService.getManagerModule().getProfileManager().getProfile(uuid);
        return profile != null ? profile.getCoins() : 0;
    }

    public void setCoins(UUID uuid, int coins) {
        Profile profile = ModuleService.getManagerModule().getProfileManager().getProfile(uuid);

        if (profile != null) {
            profile.setCoins(coins);
        }
    }

    public void addCoins(UUID uuid, int coins) {
        Profile profile = ModuleService.getManagerModule().getProfileManager().getProfile(uuid);

        if (profile != null) {
            profile.addCoins(coins);
        }
    }

    public void removeCoins(UUID uuid, int coins) {
        Profile profile = ModuleService.getManagerModule().getProfileManager().getProfile(uuid);

        if (profile != null) {
            profile.removeCoins(coins);
        }
    }
}
