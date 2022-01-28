package dev.panda.coins.module.impl;

import dev.panda.coins.backend.MongoManager;
import dev.panda.coins.module.Module;
import dev.panda.coins.profile.ProfileManager;
import dev.panda.coins.utilities.command.CommandManager;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 11-11-2021 - 16:13
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@Getter
public class ManagerModule extends Module {

    private ProfileManager profileManager;
    private MongoManager mongoManager;
    private CommandManager commandManager;

    @Override
    public String getName() {
        return "Manager";
    }

    @Override
    public int getPriority() {
        return 3;
    }

    @Override
    public void onEnable(JavaPlugin plugin) {
        this.profileManager = new ProfileManager();
        this.mongoManager = new MongoManager();
        this.commandManager = new CommandManager(plugin);
    }
}
