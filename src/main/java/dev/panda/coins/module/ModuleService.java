package dev.panda.coins.module;

import dev.panda.coins.module.impl.*;
import dev.panda.coins.profile.Profile;
import lombok.Getter;
import lombok.experimental.UtilityClass;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Comparator;
import java.util.List;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 08-11-2021 - 23:20
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@UtilityClass
public class ModuleService {

    @Getter
    private FileModule fileModule;

    @Getter
    private ServiceModule serviceModule;

    @Getter
    private ManagerModule managerModule;

    public void start(JavaPlugin plugin) {
        fileModule = new FileModule();
        serviceModule = new ServiceModule();
        managerModule = new ManagerModule();

        new ListenerModule();
        new CommandModule();

        for (Module module : ModuleService.getOrderModules()) {
            module.onEnable(plugin);
        }

        Profile.init();
    }

    public Module getByName(String name) {
        for (Module module : Module.getModules()) {
            if (module.getName().equalsIgnoreCase(name)) {
                return module;
            }
        }
        return null;
    }

    public List<Module> getOrderModules() {
        List<Module> modules = Module.getModules();
        modules.sort(Comparator.comparingInt(Module::getPriority));
        return modules;
    }
}
