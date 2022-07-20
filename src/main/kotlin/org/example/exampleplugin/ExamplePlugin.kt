package org.example.exampleplugin

import net.axay.kspigot.chat.KColors
import net.axay.kspigot.chat.literalText
import net.axay.kspigot.main.KSpigot

class ExamplePlugin : KSpigot() {

    override fun load() {
        componentLogger.info(
            literalText {
                text("The plugin was loaded!")
                color = KColors.LIGHTBLUE
            }
        )
    }

    override fun startup() {
        componentLogger.info(
            literalText {
                text("The plugin was enabled!")
                color = KColors.GREEN
            }
        )
    }

    override fun shutdown() {
        componentLogger.info(
            literalText {
                text("The plugin was disabled!")
                color = KColors.RED
            }
        )
    }
}
