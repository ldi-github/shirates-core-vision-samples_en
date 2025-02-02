package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@ios
class iOSPressKey1 : VisionTest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.appIs("[Settings]")
                        .launchApp("[Maps]")
                        .appIs("[Maps]")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.appIs("[Settings]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun pressHome() {

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS Settings Top Screen]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.screenIs("[iOS Home Screen]")
                }
            }
        }
    }

}