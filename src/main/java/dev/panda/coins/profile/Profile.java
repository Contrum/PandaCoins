package dev.panda.coins.profile;

import com.mongodb.client.model.Filters;
import com.mongodb.client.model.UpdateOptions;
import dev.panda.coins.PandaCoins;
import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.TaskUtil;
import lombok.Getter;
import lombok.Setter;
import org.bson.Document;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.UUID;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 26-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@Getter @Setter
public class Profile {

    private final UUID uuid;
    private int coins;
    private boolean loaded;

    public Profile(UUID uuid) {
        this.uuid = uuid;
        this.loaded = false;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public void removeCoins(int coins) {
        this.coins -= coins;
    }

    public Player getPlayer() {
        return Bukkit.getPlayer(uuid);
    }

    public void load() {
        Document profileDocument = ModuleService.getManagerModule().getMongoManager().getProfiles().find(new Document("uuid", uuid.toString())).first();

        if (profileDocument != null) {
            coins = profileDocument.getInteger("coins");
        }
        else {
            Document document = new Document();
            document.put("uuid", uuid.toString());
            document.put("name", getPlayer().getName());
            document.put("coins", 0);

            ModuleService.getManagerModule().getMongoManager().getProfiles().insertOne(document);
        }
    }

    public void save(boolean destroy, boolean async) {
        Document profileDocument = ModuleService.getManagerModule().getMongoManager().getProfiles().find(Filters.eq("uuid", uuid.toString())).first();
        Document document = new Document();

        document.put("uuid", uuid.toString());
        document.put("name", getPlayer().getName());
        document.put("coins", coins);

        if (async) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(PandaCoins.get(), () ->
                    ModuleService.getManagerModule().getMongoManager().getProfiles().replaceOne(profileDocument, document, new UpdateOptions().upsert(true)));
        }
        else {
            ModuleService.getManagerModule().getMongoManager().getProfiles().replaceOne(profileDocument, document, new UpdateOptions().upsert(true));
        }

        if (destroy) {
            setLoaded(false);
            ModuleService.getManagerModule().getProfileManager().getProfiles().remove(uuid);
        }
    }

    public static void init() {
        TaskUtil.runTaskTimerAsynchronously(() -> {
            if (ModuleService.getManagerModule().getProfileManager().getProfiles().isEmpty()) return;

            for (Profile profile : ModuleService.getManagerModule().getProfileManager().getProfiles().values()) {
                profile.save(false, true);
            }
        }, 300);
    }
}
