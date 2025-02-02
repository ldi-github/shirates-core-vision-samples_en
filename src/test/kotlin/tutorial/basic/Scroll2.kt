package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Scroll2 : VisionTest() {

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