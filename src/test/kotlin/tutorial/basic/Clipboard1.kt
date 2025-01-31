package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIs
import shirates.core.driver.commandextension.writeToClipboard
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Clipboard1 : VisionTest() {

    @Test
    @Order(10)
    fun element_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it.detect("Settings")
                        .clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("Settings")
                }
            }
            case(2) {
                condition {
                    it.exist("[Network & internet]")
                }.action {
                    it.clipboardText()
                }.expectation {
                    readClipboard()
                        .thisIs("Network & internet")
                }
            }
        }

    }

    @Test
    @Order(20)
    fun string_clipboard() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    "String1".writeToClipboard()
                }.expectation {
                    readClipboard()
                        .thisIs("String1")
                }
            }
        }

    }

}