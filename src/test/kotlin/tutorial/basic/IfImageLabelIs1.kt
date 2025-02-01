package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.branchextension.ifImageLabelIs
import shirates.core.vision.driver.branchextension.ifImageLabelIsNot
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.leftItem
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.testcode.VisionTest

class IfImageLabelIs1 : VisionTest() {

    @Test
    @Order(10)
    fun ifImageLabelIsTest() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageLabelIs("[Network & internet Icon]") {
                            OK("ifImageLabelIs called")
                        }.ifElse {
                            NG()
                        }
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageLabelIsNot("[Network & internet Icon]") {
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
                        .ifImageLabelIs("[App Icon]") {
                            NG()
                        }.ifElse {
                            OK("ifElse called")
                        }
                    it.detect("Network & internet")
                        .leftItem()
                        .ifImageLabelIsNot("[App Icon]") {
                            OK("ifImageLabelIsNot called")
                        }.ifElse {
                            NG()
                        }
                }
            }
        }
    }

}