package dev.panda.coins.profile;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.ChatUtil;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerPreLoginEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class ProfileListener implements Listener {

    private final ProfileManager profileManager = ModuleService.getManagerModule().getProfileManager();

    public ProfileListener(JavaPlugin plugin) {
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onAsyncPlayerPreLogin(AsyncPlayerPreLoginEvent event) {
        Profile profile = profileManager.getOrCreateProfile(event.getUniqueId());

        if (!profile.isLoaded()) {
            profile.load();
        }
    }

    @EventHandler(priority = EventPriority.HIGH, ignoreCancelled = true)
    public void onPlayerLoginEvent(PlayerLoginEvent event) {
        Profile profile = profileManager.getProfile(event.getPlayer().getUniqueId());

        if (profile == null) {
            event.setResult(PlayerLoginEvent.Result.KICK_OTHER);
            event.setKickMessage(ChatUtil.translate("&cFailed in load your profile, please join again."));
        }
    }

    @EventHandler
    private void onPlayerSaveProfile(PlayerQuitEvent event) {
        Profile profile = profileManager.getProfile(event.getPlayer().getUniqueId());
        if (profile != null) profile.save(true, true);
    }
}
