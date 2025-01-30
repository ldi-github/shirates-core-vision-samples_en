package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class AndroidPressKey1 : VisionTest() {

    @Test
    @Order(10)
    fun pressBack() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Network & internet Screen]")
                }.action {
                    it.pressBack()
                }.expectation {
                    it.screenIs("[Android Settings Top Screen]")
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
                    it.macro("[Network & internet Screen]")
                }.action {
                    it.pressHome()
                }.expectation {
                    it.screenIs("[Android Home Screen]")
                }
            }

        }
    }

    @Test
    @Order(30)
    fun pressTab() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Files Top Screen]")
                }.action {
                    it.pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                        .pressTab()
                }
            }
        }

    }

}