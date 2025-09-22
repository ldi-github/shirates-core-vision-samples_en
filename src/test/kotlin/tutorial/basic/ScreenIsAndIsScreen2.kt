package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest

class ScreenIsAndIsScreen2 : VisionTest() {

    @Test
    @Order(10)
    fun screenIs_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.screenIs("[Android Settings Top Screen]") {  // OK
                        exist("Search settings")    // OK (log is suppressed)
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun screenIs_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.screenIs("[Android Settings Top Screen]") {    // OK
                        exist("System")     // NG (log is output)
                    }
                }
            }
        }
    }

}