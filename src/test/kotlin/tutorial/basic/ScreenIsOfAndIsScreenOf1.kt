package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.branchextension.ifFalse
import shirates.core.driver.branchextension.ifTrue
import shirates.core.vision.driver.commandextension.isScreenOf
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.screenIsOf
import shirates.core.vision.testcode.VisionTest

class ScreenIsOfAndIsScreenOf1 : VisionTest() {

    @Test
    @Order(10)
    fun screenIsOf_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.screenIsOf("[Android Settings Top Screen]")
                        .screenIsOf("[Android Settings Top Screen]", "[Network & internet Screen]", "[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun screenIsOf_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.screenIsOf("[Network & internet Screen]", "[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun isScreenOf_true() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.isScreenOf("[Android Settings Top Screen]")
                        .ifTrue {
                            OK("This is [Android Settings Top Screen]")
                        }
                    it.isScreenOf("[Android Settings Top Screen]", "[Network & internet Screen]", "[System Screen]")
                        .ifTrue {
                            OK("This is of [Android Settings Top Screen],[Network & internet Screen],[System Screen]")
                        }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun isScreenOf_false() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.isScreenOf("[Network & internet Screen]", "[System Screen]")
                        .ifFalse {
                            OK("This is not of [Network & internet Screen],[System Screen]")
                        }
                }
            }
        }
    }

}