package org.example.exampleplugin

import org.bukkit.ChatColor
import net.axay.kspigot.main.KSpigot

class ExamplePlugin : KSpigot() {

    override fun startup() {
        logger.info("${ChatColor.GREEN}The Plugin was enabled!")
    }

    override fun shutdown() {
        logger.info("${ChatColor.RED}The Plugin was disabled!")
    }
}
