package dev.panda.coins.module.impl;

import com.google.common.collect.Maps;
import dev.panda.coins.module.Module;
import dev.panda.coins.utilities.file.FileConfig;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

/**
 * Created by Risas
 * Project: PandaCoins
 * Date: 11-11-2021 - 16:21
 * Twitter: @RisasDev
 * GitHub: https://github.com/RisasDev
 */

public class FileModule extends Module {

    @Getter
    private final Map<String, FileConfig> files = Maps.newHashMap();

    @Override
    public String getName() {
        return "File";
    }

    @Override
    public int getPriority() {
        return 1;
    }

    @Override
    public void onEnable(JavaPlugin plugin) {
        files.put("backend", new FileConfig(plugin, "backend.yml"));
        files.put("messages", new FileConfig(plugin, "messages.yml"));
    }

    public FileConfig getFile(String name) {
        return files.get(name);
    }

    public void reload() {
        for (FileConfig file : files.values()) {
            file.reload();
        }
    }
}
