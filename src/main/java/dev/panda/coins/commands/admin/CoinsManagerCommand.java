package dev.panda.coins.commands.admin;

import dev.panda.coins.commands.admin.subcommands.CoinsManagerGiveCommand;
import dev.panda.coins.commands.admin.subcommands.CoinsManagerSetCommand;
import dev.panda.coins.commands.admin.subcommands.CoinsManagerTakeCommand;
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

public class CoinsManagerCommand extends BaseCommand {

    public CoinsManagerCommand() {
        new CoinsManagerGiveCommand();
        new CoinsManagerSetCommand();
        new CoinsManagerTakeCommand();
    }

    @Command(name = "coinsmanager", aliases = {"coinsm", "cmanager", "cm"}, permission = "pandacoins.command.coinsmanager", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String label = command.getLabel();

        ChatUtil.toSender(sender, ChatUtil.NORMAL_LINE);
        ChatUtil.toSender(sender, " &6&lCoins Manager Help");
        ChatUtil.toSender(sender, "");
        ChatUtil.toSender(sender, " &f<> &7= &fRequired &7| &f[] &7= &fOptional");
        ChatUtil.toSender(sender, "");
        ChatUtil.toSender(sender, " &7\u25B6 &e/" + label + " give <player> <amount> &7- &fGive coins to a player");
        ChatUtil.toSender(sender, " &7\u25B6 &e/" + label + " set <player> <amount> &7- &fSet coins for a player");
        ChatUtil.toSender(sender, " &7\u25B6 &e/" + label + " take <player> <amount> &7- &fTake coins from a player");
        ChatUtil.toSender(sender, ChatUtil.NORMAL_LINE);
    }
}
