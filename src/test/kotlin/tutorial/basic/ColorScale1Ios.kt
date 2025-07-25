package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.TestDriver.testContext
import shirates.core.logging.printInfo
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

@ios
class ColorScale1Ios : VisionTest() {

    @Test
    @Order(10)
    fun colorScale_GRAY_32() {

        // default colorScale is GRAY_32
        printInfo("${testContext.visionColorScale}")

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS Settings Top Screen]")
                }.action {
                    v1 = detect("StandBy").leftItem()
                }.expectation {
                    v1.imageIs("[StandBy Icon]")    // NG (on iOS 26 Liquid Glass), OK (on iOS 18 or older)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun colorScale_GRAY_16() {

        // change colorScale to GRAY_16
        colorScaleGray16()
        printInfo("${testContext.visionColorScale}")

        scenario {
            case(1) {
                condition {
                    it.screenIs("[iOS Settings Top Screen]")
                }.action {
                    v1 = detect("StandBy").leftItem()
                }.expectation {
                    v1.imageIs("[StandBy Icon]")    // OK
                }
            }
        }
    }
}