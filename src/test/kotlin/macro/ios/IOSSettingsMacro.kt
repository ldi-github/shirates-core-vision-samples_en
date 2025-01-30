package macro.ios

import shirates.core.macro.Macro
import shirates.core.macro.MacroObject
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@MacroObject
object iOSSettingsMacro : VisionTest() {

    @Macro("[iOS Settings Top Screen]")
    fun iosSettingsTopScreen() {

        if (it.isScreen("[iOS Settings Top Screen]")) {
            if (it.canDetect("General").not()) {
                it.flickAndGoUp()
            }
            return
        }

        it.restartApp("[Settings]")
            .screenIs("[iOS Settings Top Screen]")
    }

    @Macro("[Developer Screen]")
    fun developerScreen() {

        if (it.isScreen("[Developer Screen]")) {
            if (it.canDetect("Settings")) {
                return
            }
            it.flickTopToBottom()
            if (it.canDetect("Settings")) {
                return
            }
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("Developer")
            .screenIs("[Developer Screen]")
    }

    @Macro("[General Screen]")
    fun settingsGeneralScreen() {

        if (it.isScreen("[General Screen]")) {
            return
        }

        iosSettingsTopScreen()
        it.tapWithScrollDown("General")
            .screenIs("[General Screen]")
    }

    @Macro("[Keyboards Screen]")
    fun iosKeyboardScreen() {

        if (it.isScreen("[Keyboards Screen]")) {
            if (it.canDetect(".XCUIElementTypeCell&&Keyboards")) {
                return
            }
            it.flickTopToBottom()
            if (it.canDetect(".XCUIElementTypeCell&&Keyboards")) {
                return
            }
        }

        settingsGeneralScreen()
        it.tapWithScrollDown("Keyboard")
            .screenIs("[Keyboards Screen]")
    }

    @Macro("[Language & Region Screen]")
    fun languageAndRegionScreen() {

        if (it.isScreen("[Language & Region Screen]")) {
            if (it.canDetect(".XCUIElementTypeOther&&PREFERRED LANGUAGES")) {
                return
            }
            it.flickTopToBottom()
            if (it.canDetect(".XCUIElementTypeOther&&PREFERRED LANGUAGES")) {
                return
            }
        }

        settingsGeneralScreen()
        it.tap("General")
        it.tap("Language & Region")
            .screenIs("[Language & Region Screen]")
    }
}