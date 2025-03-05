package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.goPreviousApp
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.testcode.VisionTest

class NavigationOnAndroid1 : VisionTest() {

    @Test
    fun goPreviousAppTest() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("[Settings]")
                }.expectation {
                    it.appIs("[Settings]")
                }
            }
            case(2) {
                action {
                    it.launchApp("[Maps]")
                }.expectation {
                    it.appIs("[Maps]")
                }
            }
            case(3) {
                action {
                    it.goPreviousApp()
                }.expectation {
                    it.appIs("[Settings]")
                }
            }
        }
    }

}