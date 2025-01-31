package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.platformMajorVersion
import shirates.core.vision.driver.commandextension.output
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.driver.commandextension.textIs
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
                    it.tap("Settings")  // Skipped
                }.expectation {
                    it.textIs("Settings")    // Skipped
                }
            }

            case(2) {
                action {
                    it.tap("Settings")  // Executed
                }.expectation {
                    it.textIs("Settings")    // Executed
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
                    it.tap("Settings")  // Skipped
                }.expectation {
                    it.textIs("Settings")    // Skipped
                }
            }

            case(2) {
                action {
                    it.tap("Settings")  // Skipped
                }.expectation {
                    it.textIs("Settings")    // Skipped
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
                    it.tap("Settings")  // Executed
                }.expectation {
                    it.textIs("Settings")    // Executed
                }
            }

            case(2) {
                condition {
                    NOTIMPL()   // Abort this test
                }.action {
                    it.tap("Settings")  // Not reached
                }.expectation {
                    it.textIs("Settings")   // Not reached
                }
            }

            case(3) {
                action {
                    it.tap("Settings")  // Not reached
                }.expectation {
                    it.textIs("Settings")    // Not reached
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

            case(1) {   // Not reached
                action {
                    it.tap("Settings")
                }.expectation {
                    it.textIs("Settings")
                }
            }

            case(2) {   // Not reached
                action {
                    it.tap("Settings")
                }.expectation {
                    it.textIs("Settings")
                }
            }
        }
    }

}