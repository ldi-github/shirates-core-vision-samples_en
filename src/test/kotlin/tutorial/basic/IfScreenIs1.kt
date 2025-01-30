package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.ifScreenIs
import shirates.core.vision.driver.commandextension.ifScreenIsNot
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.tap
import shirates.core.vision.testcode.VisionTest

class IfScreenIs1 : VisionTest() {

    @Test
    @Order(10)
    fun ifScreenIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    ifScreenIs("[Android Settings Top Screen]") {
                        OK("ifScreenIs called")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.tap("Network & internet")
                }.expectation {
                    ifScreenIs("[Network & internet Screen]") {
                        OK("ifScreenIs called")
                    }.ifElse {
                        NG()
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun ifScreenIsNotTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    ifScreenIsNot("[Android Settings Top Screen]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
            case(2) {
                action {
                    it.tap("Network & internet")
                }.expectation {
                    ifScreenIsNot("[Network & internet Screen]") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}