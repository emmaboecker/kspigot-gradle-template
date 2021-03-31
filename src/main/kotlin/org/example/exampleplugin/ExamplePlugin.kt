package org.example.exampleplugin

import net.md_5.bungee.api.ChatColor
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class ExamplePlugin : JavaPlugin() {

    override fun onEnable() {
        Bukkit.getLogger().info(ChatColor.GREEN.toString() + "The Plugin was successfully enabled!")
    }

    override fun onDisable() {
        Bukkit.getLogger().info(ChatColor.RED.toString() + "The Plugin was disabled!")
    }
}