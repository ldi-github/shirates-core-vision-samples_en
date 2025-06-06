package macro.android

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.isApp
import shirates.core.vision.testcode.VisionTest

@MacroObject
object ClockMacro : VisionTest() {

    @Macro("[Restart Clock]")
    fun restartClock() {

        it.terminateApp("[Clock]")
            .launchApp("[Clock]")
    }

    @Macro("[Alarm Screen]")
    fun alarmScreen() {

        if (it.isApp("[Clock]").not()) {
            restartClock()
        }
        if (it.isScreen("[Alarm Screen]").not()) {
            it.tapLast("Alarm")
        }
        it.screenIs("[Alarm Screen]")
    }

}