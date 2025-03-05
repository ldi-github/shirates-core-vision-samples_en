package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Tap1 : VisionTest() {

    @Test
    fun tap() {

        scenario {
            case(1) {
                action {
                    it.tap("Network & internet")
                        .tap("Internet")
                    it.pressBack()
                        .pressBack()
                }
            }
            case(2) {
                action {
                    it.tapWithScrollDown("Display")
                        .tapWithScrollDown("Colors")
                    it.pressBack()
                        .pressBack()
                }
            }
        }
    }

    @Test
    fun tapByCoordinates() {

        scenario {
            case(1) {
                action {
                    val v = detect("Network & internet")
                    it.tap(x = v.bounds.centerX, y = v.bounds.centerY)
                }.expectation {
                    it.screenIs("[Network & internet Screen]")
                }
            }
        }
    }

    @Test
    fun tapItemUnder() {

        scenario {
            case(1) {
                action {
                    it.tapItemUnder("Mobile, Wi-Fi, hotspot")
                }.expectation {
                    it.screenIs("[Connected devices Screen]")
                }
            }
            case(2) {
                condition {
                    it.pressBack()
                }.action {
                    withScrollDown {
                        it.tapItemUnder("Services & preferences")
                    }
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

}