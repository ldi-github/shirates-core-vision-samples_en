package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.imageLabelIs
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.testcode.VisionTest

class AssertingImage1 : VisionTest() {

    @Test
    @Order(10)
    fun imageLabelIs() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    v1 = it.detect("Network & internet")
                        .leftItem()
                }.expectation {
                    v1.imageLabelIs("[Network & internet Icon]")
                }
            }
        }
    }

}