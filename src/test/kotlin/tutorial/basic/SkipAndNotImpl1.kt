package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.platformMajorVersion
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.output
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.testcode.VisionTest

class SkipAndNotImpl1 : VisionTest() {

    @Test
    @Order(10)
    fun skipCase() {

        scenario {
            case(1) {
                condition {
                    output("platformMajorVersion=$platformMajorVersion")
                    if (platformMajorVersion > 5) {
                        SKIP_CASE("case(1) skipped.")   // Skip execution of commands (log only)
                    }
                }.action {
                    it.tap("Network & internet")  // Skipped
                }.expectation {
                    it.exist("Airplane mode")   // Skipped
                }
            }
            case(2) {
                action {
                    it.tap("Network & internet")  // Executed
                }.expectation {
                    it.exist("Airplane mode")   // Executed
                }
            }
        }
    }

    @Test
    @Order(20)
    fun skipScenario() {

        scenario {
            case(1) {
                condition {
                    output("platformMajorVersion=$platformMajorVersion")
                    if (platformMajorVersion > 5) {
                        SKIP_SCENARIO()     // Skip execution of commands (log only)
                    }
                }.action {
                    it.tap("Network & internet")  // Skipped
                }.expectation {
                    it.exist("Airplane mode")   // Skipped
                }
            }
            case(2) {
                action {
                    it.tap("Internet")  // Skipped
                }.expectation {
                    it.exist("AndroidWifi")   // Skipped
                }
            }
        }
    }

    @Test
    @Order(30)
    fun notImpl_case() {

        scenario {
            case(1) {
                action {
                    it.tap("Network & internet")  // Executed
                }.expectation {
                    it.exist("Airplane mode")   // Executed
                }
            }
            case(2) {
                condition {
                    NOTIMPL()   // Abort this test
                }.action {
                    it.tap("Internet")  // Not reached
                }.expectation {
                    it.exist("AndroidWifi")   // Not reached
                }
            }
            case(3) {
                action {
                    it.tap("AndroidWifi")  // Not reached
                }.expectation {
                    it.exist("Network details")    // Not reached
                    NOTIMPL("To be implement.")     // Not reached
                }
            }
        }
    }

    @Test
    @Order(40)
    fun notImpl_scenario() {

        scenario {
            NOTIMPL()   // Abort this scenario

            case(1) {
                action {
                    it.tap("Network & internet")    // Not reached
                }.expectation {
                    it.exist("Airplane mode")   // Not reached
                }
            }
        }
    }

}