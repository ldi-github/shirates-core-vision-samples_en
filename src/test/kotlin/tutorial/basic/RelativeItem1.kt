package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class RelativeItem1 : VisionTest() {

    @Test
    @Order(10)
    fun belowItem_aboveItem() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    v1 = findImage("[Connected devices Icon]")
                }.expectation {
                    v1.belowItem().imageLabelIs("[Apps Icon]")
                    v1.aboveItem().imageLabelIs("[Network & internet Icon]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun rightItem_leftItem() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Files Top Screen]")
                }.action {
                    v1 = findImage("[Audio Button]")
                }.expectation {
                    v1.rightItem(include = true).imageLabelIs("[Videos Button]")
                    v1.leftItem(include = true).imageLabelIs("[Images Button]")
                }
            }
        }
    }
}