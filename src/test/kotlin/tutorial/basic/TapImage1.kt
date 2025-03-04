package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.pressBack
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.driver.commandextension.tapImage
import shirates.core.vision.driver.commandextension.withScrollDown
import shirates.core.vision.testcode.VisionTest

class TapImage1 : VisionTest() {

    @Test
    fun tapImage() {

        scenario {
            case(1) {
                action {
                    it.tapImage("[Network & internet Icon]")
                }.expectation {
                    it.screenIs("[Network & internet Screen]")
                }
            }
            case(2) {
                condition {
                    it.pressBack()
                }.action {
                    withScrollDown {
                        it.tapImage("[System Icon]")
                    }
                }.expectation {
                    it.screenIs("[System Screen]")
                }
            }
        }
    }

}