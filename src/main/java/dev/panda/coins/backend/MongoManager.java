package dev.panda.coins.backend;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import dev.panda.coins.PandaCoins;
import dev.panda.coins.services.BackendService;
import dev.panda.coins.utilities.ChatUtil;
import lombok.Getter;
import org.bson.Document;
import org.bukkit.Bukkit;

import java.util.ArrayList;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 27-01-2022
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

@Getter
public class MongoManager {

    private MongoCollection<Document> profiles;

    public MongoManager() {
        try {
            MongoDatabase mongoDatabase;

            if (BackendService.MONGO_AUTHENTICATION_ENABLED) {
                mongoDatabase = new MongoClient(new ServerAddress(BackendService.MONGO_HOST, BackendService.MONGO_PORT),
                        MongoCredential.createCredential(
                                BackendService.MONGO_AUTHENTICATION_USERNAME,
                                BackendService.MONGO_AUTHENTICATION_DATABASE,
                                BackendService.MONGO_AUTHENTICATION_PASSWORD.toCharArray()),
                        MongoClientOptions.builder().build()).getDatabase(BackendService.MONGO_DATABASE);
            }
            else {
                mongoDatabase = new MongoClient(BackendService.MONGO_HOST, BackendService.MONGO_PORT)
                        .getDatabase(BackendService.MONGO_DATABASE);
            }

            if (!mongoDatabase.listCollectionNames().into(new ArrayList<>()).contains("profiles")){
                mongoDatabase.createCollection("profiles");
            }

            profiles = mongoDatabase.getCollection("profiles");

            ChatUtil.log("&a[PandaCoins] MongoDB successfully connected");
        }
        catch (Exception ex) {
            ChatUtil.log("&c[PandaCoins] Plugin was disabled as it failed to connect to the MongoDB");
            Bukkit.getServer().getPluginManager().disablePlugin(PandaCoins.get());
        }
    }
}
