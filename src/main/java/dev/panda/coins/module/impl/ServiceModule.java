package dev.panda.coins.module.impl;

import dev.panda.coins.module.Module;
import dev.panda.coins.module.ModuleService;
import dev.panda.coins.services.BackendService;
import dev.panda.coins.services.MessageService;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 11-11-2021 - 16:21
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class ServiceModule extends Module {

    @Override
    public String getName() {
        return "Service";
    }

    @Override
    public int getPriority() {
        return 2;
    }

    @Override
    public void onEnable(JavaPlugin plugin) {
        reload(true);
    }

    public void reload(boolean start) {
        if (!start) ModuleService.getFileModule().reload();
        BackendService.init();
        MessageService.init();
    }
}
