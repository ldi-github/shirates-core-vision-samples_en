package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.detect
import shirates.core.vision.driver.commandextension.dontExist
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.macro
import shirates.core.vision.driver.commandextension.onRowOf
import shirates.core.vision.driver.commandextension.onThisElementRegion
import shirates.core.vision.driver.commandextension.row
import shirates.core.vision.testcode.VisionTest

@ios
class SettingWorkingRegion3Ios : VisionTest() {

    @Test
    @Order(10)
    fun row_onRowOf() {

        scenario {
            case(1) {
                condition {
                    it.macro("[iOS Settings Top Screen]")
                }.expectation {
                    it.detect("Apple Account")
                        .row()
                        .onThisElementRegion {
                            it.exist("Sign in to access*")
                            it.dontExist("General")
                        }
                    it.detect("General")
                        .row()
                        .onThisElementRegion {
                            it.dontExist("Sign in to access*")
                            it.exist("General")
                        }
                }
            }
            case(2) {
                expectation {
                    it.onRowOf("Apple Account") {
                        it.exist("Sign in to access*")
                        it.dontExist("General")
                    }
                    it.onRowOf("General") {
                        it.dontExist("Sign in to access*")
                        it.exist("General")
                    }
                }
            }
        }
    }

}