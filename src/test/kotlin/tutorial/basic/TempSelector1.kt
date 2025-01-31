package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.tempSelector
import shirates.core.vision.testcode.VisionTest

class TempSelector1 : VisionTest() {

    @Test
    @Order(10)
    fun tempSelector1() {

        tempSelector("[First Item]", "Network & internet")

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it.tap("[First Item]")
                }.expectation {
                    it.screenIs("[Network & internet Screen]")
                }
            }
        }
    }

}