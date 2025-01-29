package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class DetectAndAssert1 : VisionTest() {

    @Test
    @Order(10)
    fun detectAndAssert1_OK() {

        scenario {
            case(1) {
                expectation {
                    it.detect("Settings")
                        .textIs("Settings")   // OK
                }
            }
        }
    }

    @Test
    @Order(20)
    fun detectAndAssert2_NG() {

        scenario {
            case(1) {
                expectation {
                    it.detect("Settings")
                        .textIs("Network & internet")   // NG
                }
            }
        }
    }

}