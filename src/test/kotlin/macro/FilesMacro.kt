package macro.android

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.isScreen
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.terminateApp
import shirates.core.vision.driver.waitForDisplay
import shirates.core.vision.testcode.VisionTest

@MacroObject
object FilesMacro : VisionTest() {

    @Macro("[Restart Files]")
    fun restartFiles() {

        it.terminateApp("com.google.android.documentsui")
            .launchApp("com.google.android.documentsui")
    }

    @Macro("[Files Top Screen]")
    fun mapsTopScreen() {

        if (it.isScreen("[Files Top Screen]")) {
            return
        }

        it.terminateApp("com.google.android.documentsui")
            .launchApp("com.google.android.documentsui")
            .waitForDisplay("Downloads")

        if (it.isScreen("[Files Top Screen]")) {
            return
        }

        restartFiles()

        it.screenIs("[Files Top Screen]")
    }
}