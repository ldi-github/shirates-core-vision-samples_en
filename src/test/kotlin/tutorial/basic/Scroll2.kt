package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Scroll2 : VisionTest() {

    @Test
    @Order(10)
    fun scrollRight_scrollLeft() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Calendar Week Screen]")
                }.action {
                    it
                        .scrollRight()
                        .scrollLeft()
                }
            }
            case(2) {
                action {
                    it
                        .scrollRight(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollRight(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                        .scrollLeft(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollLeft(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                }
            }
        }
    }

    @Order(20)
    @Test
    fun scrollToRightEdge_scrollToLeftEdge() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Maps Top Screen]")
                }.action {
                    it.detect("Restaurants").onLine {
                        it.scrollToRightEdge()
                    }
                }.expectation {
                    it.exist("More")
                }
            }
            case(2) {
                action {
                    it.detect("More").onLine {
                        it.scrollToLeftEdge()
                    }
                }.expectation {
                    it.dontExist("More")
                }
            }
        }
    }

}