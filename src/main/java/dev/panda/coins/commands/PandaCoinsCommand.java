package dev.panda.coins.commands;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.ChatUtil;
import dev.panda.coins.utilities.command.BaseCommand;
import dev.panda.coins.utilities.command.Command;
import dev.panda.coins.utilities.command.CommandArgs;
import org.bukkit.command.CommandSender;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class PandaCoinsCommand extends BaseCommand {

    @Command(name = "pandacoins", permission = "pandacoins.use", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String[] args = command.getArgs();

        if (args.length == 0) {
            sender.sendMessage(ChatUtil.translate("&cUsage: /" + command.getLabel() + " reload"));
            return;
        }

        if (args[0].equalsIgnoreCase("reload")) {
            if (sender.hasPermission("pandacoins.command.reload")) {
                ModuleService.getServiceModule().reload(false);
                sender.sendMessage(ChatUtil.translate("&aPandaCoins reloaded!"));
            }
        }
    }
}
