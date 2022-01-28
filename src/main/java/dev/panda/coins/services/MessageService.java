package dev.panda.coins.services;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.file.FileConfig;
import lombok.experimental.UtilityClass;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@UtilityClass
public class MessageService {

    private final FileConfig messageConfig = ModuleService.getFileModule().getFile("messages");

    public String COINS_COMMAND_YOUR;
    public String COINS_COMMAND_OTHER;

    public void init() {
        COINS_COMMAND_YOUR = messageConfig.getString("coins-command.your");
        COINS_COMMAND_OTHER = messageConfig.getString("coins-command.other");
    }
}
