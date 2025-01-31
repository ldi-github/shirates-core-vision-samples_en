package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.logging.printInfo
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.driver.waitForDisplay
import shirates.core.vision.testcode.VisionTest

class Memo1 : VisionTest() {

    @Order(10)
    @Test
    fun writeMemo_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .tap("Storage")
                        .waitForDisplay("GB")
                }.action {
                    writeMemo("System", it.detect("System").rightText().text)
                    writeMemo("Apps", it.detect("Apps").rightText().text)
                }.expectation {
                    readMemo("System").printInfo()
                    readMemo("Apps").printInfo()
                }
            }
        }
    }

    @Order(20)
    @Test
    fun memoTextAs_readMemo() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Network & internet Screen]")
                }.action {
                    it.detect("SIMs").belowText().memoTextAs("SIMs")
                    it.detect("VPN").belowText().memoTextAs("VPN")
                }.expectation {
                    it.readMemo("SIMs").thisIs("T-Mobile")
                    it.readMemo("VPN").thisIs("None")
                }
            }
        }

    }
}