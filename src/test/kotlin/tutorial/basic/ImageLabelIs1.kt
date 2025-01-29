package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ImageLabelIs1 : VisionTest() {

    @Test
    @Order(10)
    fun imageLabelIs() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    v1 = it.detect("Network & internet")
                        .leftItem()
                }.expectation {
                    v1.imageLabelIs("[Network & internet Icon]")
                }
            }
            case(2) {
                expectation {
                    v1.imageFullLabelIs("@a[Android Settings App][Android Settings Top Screen][Network & internet Icon]")
                }
            }
        }
    }

}