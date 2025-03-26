package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.eventextension.onScreen
import shirates.core.vision.testcode.VisionTest

class ScreenHandler1 : VisionTest() {

    @Test
    @Order(10)
    fun screenHandler() {

        scenario {
            case(1) {
                condition {
                    onScreen("[Android Settings Top Screen]") {
                        it.tap("Network & internet")
                    }
                    onScreen("[Network & internet Screen]") {
                        it.tap("Internet")
                    }
                }.action {
                    it.macro("[Android Settings Top Screen]")
                    /**
                     * onScreen("[Android Settings Top Screen]") is called
                     */
                    /**
                     * onScreen("[Network & internet Screen]") is called
                     */
                }.expectation {
                    it.screenIs("[Internet Screen]")
                }
            }
        }
    }

}