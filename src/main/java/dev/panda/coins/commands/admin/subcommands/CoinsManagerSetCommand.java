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

public class CoinsManagerSetCommand extends BaseCommand {

    @Command(name = "coinsmanager.set", aliases = {"coinsm.set", "cmanager.set", "cm.set"}, permission = "pandacoins.command.coinsmanager.set", inGameOnly = false)
    @Override
    public void onCommand(CommandArgs command) {
        CommandSender sender = command.getSender();
        String label = command.getLabel().replace(".set", "");
        String[] args = command.getArgs();

        if (args.length < 2) {
            sender.sendMessage(ChatUtil.translate("&cUsage: /" + label + " set <player> <amount>"));
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
        profile.setCoins(amount);
        sender.sendMessage(ChatUtil.translate("&eCoins set to &7" + JavaUtil.localeFormat(amount) + " &efor &6" + player.getName() + "&e."));
    }
}
