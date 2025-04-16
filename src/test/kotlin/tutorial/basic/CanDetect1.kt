package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIsFalse
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class CanDetect1 : VisionTest() {

    @Test
    @Order(10)
    fun canDetect() {

        scenario {
            case(1) {
                expectation {
                    it.canDetect("Settings")
                        .thisIsTrue("<Settings> found.")
                }
            }
            case(2) {
                expectation {
                    it.canDetectWithScrollDown("System")
                        .thisIsTrue("<System> found with scroll down.")
                }
            }
            case(3) {
                expectation {
                    it.canDetectWithScrollUp("Settings")
                        .thisIsTrue("<Settings> found with scroll up.")
                }
            }
            case(4) {
                expectation {
                    withScrollDown {
                        it.canDetectAll("Settings", "System")
                            .thisIsTrue("<Settings> found with scroll down.")
                    }
                }
            }
            case(5) {
                expectation {
                    withScrollUp {
                        it.canDetectAll("System", "Settings")
                            .thisIsTrue("<Settings> found with scroll up.")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun canDetect_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.canDetect("Network & internet")
                        .thisIsTrue(message = "canDetect(\"Network & internet\") is true")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun canDetect_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.canDetect("Network business")
                        .thisIsFalse("canDetect(\"Network business\") is false")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun canDetectWithScrollDown_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.canDetectWithScrollDown("System")
                        .thisIsTrue("canDetectWithScrollDown(\"System\") is true")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun canDetectWithScrollDown_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.canDetectWithScrollDown("Network business")
                        .thisIsFalse("canDetectWithScrollDown(\"Network business\") is false")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun canDetectWithScrollUp_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickBottomToTop()
                }.expectation {
                    it.canDetectWithScrollUp("Network & internet")
                        .thisIsTrue("canDetectWithScrollUp(\"Network & internet\") is true")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun canDetectWithScrollUp_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickBottomToTop()
                }.expectation {
                    it.canDetectWithScrollUp("Network business")
                        .thisIsFalse("canDetectWithScrollUp(\"Network business\") is false")
                }
            }
        }
    }

}