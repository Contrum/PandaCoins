package dev.panda.coins.module.impl;

import dev.panda.coins.module.Module;
import dev.panda.coins.profile.ProfileListener;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 08-11-2021 - 23:26
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class ListenerModule extends Module {

    @Override
    public String getName() {
        return "Listener";
    }

    @Override
    public int getPriority() {
        return 4;
    }

    @Override
    public void onEnable(JavaPlugin plugin) {
        new ProfileListener(plugin);
    }
}
