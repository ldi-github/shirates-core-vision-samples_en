package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.storage.data
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.sendKeys
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class Data1 : VisionTest() {

    @Test
    @Order(10)
    fun data1() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Search Screen]")
                        .tap("Search settings")
                }.action {
                    it.sendKeys(data("[product1].product_name"))
                }.expectation {
                    it.textIs("Super High Tension")
                }
            }
        }

    }
}