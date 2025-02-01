package macro

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.commandextension.waitScreen
import shirates.core.vision.testcode.VisionTest

@MacroObject
object MacroObject1 : VisionTest() {

    @Macro("[Network preferences Screen]")
    fun internetScreen() {

        it.waitScreen("[Android Settings Top Screen]")
            .tap("Network & internet")
        it.waitScreen("[Network & internet Screen]")
            .tap("Internet")
        it.waitScreen("[Internet Screen]")
            .tap("Network preferences")
    }

}