package dev.panda.coins.module.impl;

import dev.panda.coins.commands.PandaCoinsCommand;
import dev.panda.coins.commands.admin.CoinsManagerCommand;
import dev.panda.coins.commands.user.CoinsCommand;
import dev.panda.coins.module.Module;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 08-11-2021 - 22:48
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class CommandModule extends Module {

    @Override
    public String getName() {
        return "Command";
    }

    @Override
    public int getPriority() {
        return 5;
    }

    @Override
    public void onEnable(JavaPlugin plugin) {
        new PandaCoinsCommand();
        new CoinsCommand();
        new CoinsManagerCommand();
    }
}
