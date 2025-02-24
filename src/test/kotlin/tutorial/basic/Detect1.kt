package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.detectWithScrollDown
import shirates.core.vision.driver.commandextension.output
import shirates.core.vision.testcode.VisionTest

class Detect1 : VisionTest() {

    @Test
    @Order(10)
    fun detect() {

        scenario {
            case(1) {
                action {
                    it.detect("Search settings")
                    output(it)

                    it.detect("Network & internet")
                    output(it)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun detectWithScrollDown_detectWithScrollUp() {

        scenario {
            case(1) {
                action {
                    it.detectWithScrollDown("Tips & support")
                    output(it)
                }
            }
        }
    }

    @Test
    @Order(30)
    fun detect_patterns() {

        scenario {
            case(1) {
                action {
                    it.detect("Search settings")
                    output(it)

                    it.detect("*arch sett*")
                    output(it)

                    it.detect("Search*")
                    output(it)

                    it.detect("*settings")
                    output(it)

                    it.detect("Search*&&*settings")
                    output(it)
                }
            }
        }
    }

}