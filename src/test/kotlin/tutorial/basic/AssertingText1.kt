package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class AssertingText1 : VisionTest() {

    @Test
    @Order(10)
    fun belowTextIs_aboveTextIs() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it.detect("Network & internet")
                }.expectation {
                    it.textIs("Network & internet")
                        .belowTextIs("Mobile, Wi-Fi, hotspot")
                        .aboveTextIs("Network & internet")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun rightTextIs_leftTextIs() {

        scenario {
            case(1) {
                condition {
                    it.pressHome()
                    it.screenIs("[Android Home Screen]")
                }.action {
                    it.detect("Play Store")
                }.expectation {
                    it.textIs("Play Store")
                        .rightTextIs("Gmail")
                        .leftTextIs("Play Store")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun textIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it.detect("Network & internet")
                }.expectation {
                    it.textIs("Connected devices")
                }
            }
        }
    }

}