package dev.panda.coins;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.ChatUtil;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 26-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class PandaCoins extends JavaPlugin {

    @Override
    public void onEnable() {
        ChatUtil.log(ChatUtil.NORMAL_LINE);
        ChatUtil.log("&6&lPandaCoins");
        ChatUtil.log("");
        ChatUtil.log("&eAuthor&7: &f" + getDescription().getAuthors());
        ChatUtil.log("&eVersion&7: &f" + getDescription().getVersion());
        ChatUtil.log("&eGitHub&7: &f" + getDescription().getWebsite());
        ChatUtil.log("");
        ChatUtil.log(ChatUtil.NORMAL_LINE);

        ModuleService.start(this);
    }

    @Override
    public void onDisable() {
        ModuleService.getManagerModule().getProfileManager().saveAll();
    }

    public static PandaCoins get() {
        return getPlugin(PandaCoins.class);
    }
}
