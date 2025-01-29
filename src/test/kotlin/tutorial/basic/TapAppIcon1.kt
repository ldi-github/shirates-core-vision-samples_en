package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.testcode.VisionTest

class TapAppIcon1 : VisionTest() {

    @Test
    fun tapAppIcon() {

        scenario {
            case(1) {
                action {
                    it.launchApp("Chrome")
                }.expectation {
                    it.appIs("[Chrome]")
                }
            }
            case(2) {
                action {
                    it.launchApp("Play Store")
                }.expectation {
                    it.appIs("[Play Store]")
                }
            }
        }
    }

}