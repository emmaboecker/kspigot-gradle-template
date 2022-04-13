package org.example.exampleplugin

import net.axay.kspigot.main.KSpigot

class ExamplePlugin : KSpigot() {

    override fun startup() {
        logger.info("The Plugin was enabled!")
    }

    override fun shutdown() {
        logger.info("The Plugin was disabled!")
    }
}
