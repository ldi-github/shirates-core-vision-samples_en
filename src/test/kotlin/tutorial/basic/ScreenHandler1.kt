package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
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
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    onScreen("[Network & internet Screen]") {
                        it.tap("Internet")
                    }.onScreen("[Internet Screen]") {
                        it.tap("AndroidWifi")
                    }
                    it.tap("Network & internet")
                    /**
                     * onScreen("[Network & internet Screen]") is called
                     */
                    /**
                     * onScreen("[Internet Screen]") is called
                     */
                }.expectation {
                    it.exist("Network details")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun screenHandler_keep() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    onScreen("[Network & internet Screen]") { c ->
                        it.tap("Internet")
                        c.keep = true   // The screen handler keeps registered. Not released.
                    }
                    it.tap("Network & internet")
                }.expectation {
                    it.exist("Network preferences")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun screenHandler_permanent() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    onScreen("[Network & internet Screen]", permanent = true) {
                        it.tap("Internet")
                    }
                    it.tap("Network & internet")
                }.expectation {
                    it.exist("Network preferences")
                }
            }
        }
    }

}