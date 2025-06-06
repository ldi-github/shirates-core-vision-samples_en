package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.doUntilTrue
import shirates.core.vision.testcode.VisionTest

class DoUntilTrue1 : VisionTest() {

    @Test
    @Order(10)
    fun doUntilTrue_action() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    doUntilTrue {
                        it.scrollDown()
                        it.canDetect("System")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun doUntilTrue_onTimeout() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    doUntilTrue(
                        waitSeconds = 3.0,
                        onTimeout = { c ->
                            SKIP_SCENARIO("Timeout. (waitSeconds=${c.waitSeconds})")
                        }
                    ) {
                        it.swipeCenterToTop()
                        it.canDetect("System")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun doUntilTrue_onMaxLoop() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                    it.launchApp()
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    doUntilTrue(
                        maxLoopCount = 2,
                        onMaxLoop = { c ->
                            SKIP_SCENARIO("MaxLoopCount. (maxLoopCount=${c.maxLoopCount})")
                        }
                    ) {
                        it.swipeCenterToTop()
                        it.canDetect("System")
                    }
                    it.tap()
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun doUntilTrue_onError() {

        scenario {
            case(1) {
                expectation {
                    doUntilTrue(
                        onError = { c ->
                            output("${c.error} (${c.count})")
                            c.cancelRetry = c.count >= 3
                        },
                    ) {
                        it.detect("no-exist", waitSeconds = 0.0)   // throws TestDriverException
                        false
                    }
                }
            }
        }
    }

}