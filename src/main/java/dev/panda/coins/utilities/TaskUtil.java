package dev.panda.coins.utilities;

import dev.panda.coins.PandaCoins;
import lombok.experimental.UtilityClass;
import org.bukkit.scheduler.BukkitRunnable;

@UtilityClass
public class TaskUtil {
    
    public void run(Runnable runnable) {
        PandaCoins.get().getServer().getScheduler().runTask(PandaCoins.get(), runnable);
    }

    public void runTimer(Runnable runnable, long delay, long timer) {
        PandaCoins.get().getServer().getScheduler().runTaskTimer(PandaCoins.get(), runnable, delay, timer);
    }

    public void runTimer(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimer(PandaCoins.get(), delay, timer);
    }

    public void runTimerAsync(Runnable runnable, long delay, long timer) {
        PandaCoins.get().getServer().getScheduler().runTaskTimerAsynchronously(PandaCoins.get(), runnable, delay, timer);
    }

    public void runTimerAsync(BukkitRunnable runnable, long delay, long timer) {
        runnable.runTaskTimerAsynchronously(PandaCoins.get(), delay, timer);
    }

    public void runLater(Runnable runnable, long delay) {
        PandaCoins.get().getServer().getScheduler().runTaskLater(PandaCoins.get(), runnable, delay);
    }

    public void runLaterAsync(Runnable runnable, long delay) {
        PandaCoins.get().getServer().getScheduler().runTaskLaterAsynchronously(PandaCoins.get(), runnable, delay);
    }

    public void runTaskTimerAsynchronously(Runnable runnable, int delay) {
        PandaCoins.get().getServer().getScheduler().runTaskTimerAsynchronously(PandaCoins.get(), runnable, 20L * delay, 20L * delay);
    }

    public void runAsync(Runnable runnable) {
        PandaCoins.get().getServer().getScheduler().runTaskAsynchronously(PandaCoins.get(), runnable);
    }
}