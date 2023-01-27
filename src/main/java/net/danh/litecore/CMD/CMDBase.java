package net.danh.litecore.CMD;

import org.bukkit.command.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;
import java.util.Objects;

public abstract class CMDBase implements CommandExecutor, TabCompleter {

    public CMDBase(JavaPlugin plugin, String name) {
        PluginCommand pluginCommand = plugin.getCommand(name);
        Objects.requireNonNull(pluginCommand).setExecutor(this);
        pluginCommand.setTabCompleter(this);
    }

    public abstract void execute(CommandSender c, String[] args);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        execute(sender, args);
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        return TabComplete(sender, args);
    }

    public abstract List<String> TabComplete(CommandSender sender, String[] args);
}
