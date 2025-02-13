package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class RelativeText1 : VisionTest() {

    @Test
    @Order(10)
    fun belowText_aboveText() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Network & internet Screen]")
                }.action {
                    v1 = detect("Airplane mode")
                }.expectation {
                    v1.belowText().textIs("Hotspot & tethering")
                    v1.aboveText().textIs("T-Mobile")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun rightText_leftText() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Files Top Screen]")
                }.action {
                    v1 = detect("Audio")
                }.expectation {
                    v1.rightText().textIs("Videos")
                    v1.leftText().textIs("Images")
                }
            }
        }
    }
}