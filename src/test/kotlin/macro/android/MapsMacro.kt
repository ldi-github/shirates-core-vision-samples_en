package macro.android

import ifCanDetect
import shirates.core.driver.branchextension.ifCanSelect
import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@MacroObject
object MapsMacro : VisionTest() {

    @Macro("[Maps Top Screen]")
    fun mapsTopScreen() {

        if (it.isScreen("[Maps Top Screen]")) {
            return
        }

        it.terminateApp("[Maps]")
            .launchApp("[Maps]")
            .ifCanDetect("*to send you notifications?") {
                it.tap("Allow")
            }
            .ifCanSelect("Make it your map") {
                it.tap("SKIP")
            }

        if (it.isScreen("[Maps Top Screen]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[Maps Top Screen]")) {
            return
        }

        it.tapCenterOfScreen()
        if (it.isScreen("[Maps Top Screen]")) {
            return
        }

        it.screenIs("[Maps Top Screen]")
    }
}