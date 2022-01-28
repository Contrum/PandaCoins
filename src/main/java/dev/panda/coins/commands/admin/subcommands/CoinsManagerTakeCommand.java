package dev.panda.coins.commands.admin.subcommands;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.profile.Profile;
import dev.panda.coins.utilities.ChatUtil;
import dev.panda.coins.utilities.JavaUtil;
import dev.panda.coins.utilities.command.BaseCommand;
import dev.panda.coins.utilities.command.Command;
import dev.panda.coins.utilities.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class CoinsManagerTakeCommand extends BaseCommand {

    @Command(name = "coinsmanager.take", aliases = {"coinsm.take", "cmanager.take", "cm.take"}, permission = "pandacoins.command.coinsmanager.take", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String label = command.getLabel().replace(".take", "");
        String[] args = command.getArgs();

        if (args.length < 2) {
            sender.sendMessage(ChatUtil.translate("&cUsage: /" + label + " take <player> <amount>"));
            return;
        }

        Player player = Bukkit.getPlayer(args[0]);

        if (player == null) {
            sender.sendMessage(ChatUtil.translate("&cPlayer " + args[0] + " not found!"));
            return;
        }

        Integer amount = JavaUtil.parseInt(args[1]);

        if (amount == null) {
            sender.sendMessage(ChatUtil.translate("&cAmount must be a number."));
            return;
        }

        Profile profile = ModuleService.getManagerModule().getProfileManager().getProfile(player.getUniqueId());
        profile.removeCoins(amount);
        sender.sendMessage(ChatUtil.translate("&eYou have taken &7" + JavaUtil.localeFormat(amount) + " &ecoins from &6" + player.getName() + "&e."));
    }
}
