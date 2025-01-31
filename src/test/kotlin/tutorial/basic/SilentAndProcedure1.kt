package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.silent
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SilentAndProcedure1 : VisionTest() {

    @Test
    @Order(10)
    fun silent1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android Settings Top Screen]")
                }.action {
                    describe("Tap <System>")
                    silent {
                        it.scrollToBottom()
                            .tap("System")
                    }
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun procedure1() {

        scenario {
            case(1) {
                condition {
                    macro("[Android Settings Top Screen]")
                }.action {
                    procedure("Tap <System>") {
                        it.scrollToBottom()
                            .tap("System")
                    }
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

}