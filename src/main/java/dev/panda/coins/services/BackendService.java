package dev.panda.coins.services;

import dev.panda.coins.module.ModuleService;
import dev.panda.coins.utilities.file.FileConfig;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BackendService {

    private final FileConfig backendConfig = ModuleService.getFileModule().getFile("backend");

    public String MONGO_HOST;
    public int MONGO_PORT;
    public String MONGO_DATABASE;
    public boolean MONGO_AUTHENTICATION_ENABLED;
    public String MONGO_AUTHENTICATION_USERNAME;
    public String MONGO_AUTHENTICATION_PASSWORD;
    public String MONGO_AUTHENTICATION_DATABASE;

    public void init() {
        MONGO_HOST = backendConfig.getString("mongo.host");
        MONGO_PORT = backendConfig.getInt("mongo.port");
        MONGO_DATABASE = backendConfig.getString("mongo.database");
        MONGO_AUTHENTICATION_ENABLED = backendConfig.getBoolean("mongo.authentication.enabled");
        MONGO_AUTHENTICATION_USERNAME = backendConfig.getString("mongo.authentication.username");
        MONGO_AUTHENTICATION_PASSWORD = backendConfig.getString("mongo.authentication.password");
        MONGO_AUTHENTICATION_DATABASE = backendConfig.getString("mongo.authentication.database");
    }
}
