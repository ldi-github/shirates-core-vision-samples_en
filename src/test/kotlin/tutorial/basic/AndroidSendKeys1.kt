package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.clearInput
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.sendKeys
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class AndroidSendKeys1 : VisionTest() {

    @Test
    @Order(10)
    fun sendKeys_clearInput() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Search Screen]")
                }.action {
                    it.sendKeys("clock")
                }.expectation {
                    it.textIs("clock")
                }
            }
            case(2) {
                action {
                    it.clearInput()
                }.expectation {
                    it.textIs("Search settings")
                }
            }
        }
    }

}