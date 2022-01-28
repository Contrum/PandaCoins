package dev.panda.coins.commands.user;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.profile.Profile;
import dev.panda.coins.profile.ProfileManager;
import dev.panda.coins.services.MessageService;
import dev.panda.coins.utilities.ChatUtil;
import dev.panda.coins.utilities.JavaUtil;
import dev.panda.coins.utilities.command.BaseCommand;
import dev.panda.coins.utilities.command.Command;
import dev.panda.coins.utilities.command.CommandArgs;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class CoinsCommand extends BaseCommand {

    private final ProfileManager profileManager = ModuleService.getManagerModule().getProfileManager();

    @Command(name = "coins")
    @Override
    public void onCommand(CommandArgs command) {
        Player player = command.getPlayer();
        String[] args = command.getArgs();

        if (args.length == 0) {
            Profile playerProfile = profileManager.getProfile(player.getUniqueId());
            player.sendMessage(ChatUtil.translate(MessageService.COINS_COMMAND_YOUR
                    .replace("<coins>", JavaUtil.localeFormat(playerProfile.getCoins()))));
            return;
        }

        Player target = Bukkit.getPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatUtil.translate("&cPlayer " + args[0] + " not found!"));
            return;
        }

        Profile targetProfile = profileManager.getProfile(target.getUniqueId());
        player.sendMessage(ChatUtil.translate(MessageService.COINS_COMMAND_OTHER
                .replace("<player>", target.getName())
                .replace("<gems>", JavaUtil.localeFormat(targetProfile.getCoins()))));
    }
}
