package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.branchextension.ifImageIs
import shirates.core.vision.driver.branchextension.ifImageIsNot
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.testcode.VisionTest

class IfImageIs1 : VisionTest() {

    @Test
    @Order(10)
    fun ifImageIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageIs("[Network & internet Icon]") {
                            OK("ifImageIs called")
                        }.ifElse {
                            NG()
                        }
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageIsNot("[Network & internet Icon]") {
                            NG()
                        }.ifElse {
                            OK("ifElse called")
                        }
                }
            }
            case(2) {
                expectation {
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageIs("[App Icon]") {
                            NG()
                        }.ifElse {
                            OK("ifElse called")
                        }
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageIsNot("[App Icon]") {
                            OK("ifImageIsNot called")
                        }.ifElse {
                            NG()
                        }
                }
            }
        }
    }

}