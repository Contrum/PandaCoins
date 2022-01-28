package dev.panda.coins.module;

import lombok.Getter;
import lombok.Setter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public abstract class Module {

    private String name;
    private int priority;

    @Getter
    private static final List<Module> modules = new ArrayList<>();

    public Module() {
        modules.add(this);
    }

    public abstract void onEnable(JavaPlugin plugin);
}
