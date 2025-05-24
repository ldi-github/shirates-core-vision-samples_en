package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.detectLast
import shirates.core.vision.driver.commandextension.textIs
import shirates.core.vision.testcode.VisionTest

class Detect2 : VisionTest() {

    @Test
    @Order(10)
    fun detectLast() {

        scenario {
            case(1) {
                action {
                    it.detect("*settings*")
                }.expectation {
                    it.textIs("Settings")
                }
            }
            case(2) {
                action {
                    it.detectLast("*settings*")
                }.expectation {
                    it.textIs("Search settings")
                }
            }
        }
    }

}