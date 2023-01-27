package net.danh.litecore.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Event {
    public static void registerEvents(JavaPlugin plugin, Listener... listeners) {
        Arrays.stream(listeners).collect(Collectors.toList()).forEach(events -> Bukkit.getPluginManager().registerEvents(events, plugin));
    }
}
