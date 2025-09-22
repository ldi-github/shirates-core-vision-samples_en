package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.testContext
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
                    v1 = findImage("[Notifications Icon]")
                }.expectation {
                    v1.belowItem().imageIs("[Sound & vibration Icon]")
                    v1.aboveItem().imageIs("[Apps Icon]")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun rightItem_leftItem() {

        testContext.segmentMarginHorizontal = 5

        scenario {
            case(1) {
                condition {
                    it.macro("[Files Top Screen]")
                }.action {
                    v1 = findImage("[Audio Button]")
                }.expectation {
                    v1.rightItem(include = true).imageIs("[Videos Button]")
                    v1.leftItem(include = true).imageIs("[Images Button]")
                }
            }
        }
    }
}