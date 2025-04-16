package tutorial.basic

import ifCanDetect
import ifCanDetectNot
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.scrollToBottom
import shirates.core.vision.testcode.VisionTest

class IfCanDetect1 : VisionTest() {

    @Test
    @Order(10)
    fun ifCanDetectTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    ifCanDetect("Network & internet") {
                        OK("ifCanDetect called")
                    }.ifElse {
                        NG()
                    }

                    ifCanDetectNot("System") {
                        OK("ifCanDetectNot called")
                    }.ifElse {
                        NG()
                    }
                }
            }
            case(2) {
                action {
                    it.scrollToBottom()
                }.expectation {
                    ifCanDetect("Network & internet") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }

                    ifCanDetectNot("System") {
                        NG()
                    }.ifElse {
                        OK("ifElse called")
                    }
                }
            }
        }
    }

}