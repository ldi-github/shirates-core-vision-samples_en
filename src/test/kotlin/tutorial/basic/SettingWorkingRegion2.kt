package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SettingWorkingRegion2 : VisionTest() {

    @Test
    @Order(10)
    fun cellOf_onCellOf() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Alarm Screen]")
                }.expectation {
                    it.detect("8:30AM")
                        .cell()
                        .onThisElementRegion {
                            it.exist("Mon, Tue, Wed, Thu, Fri")
                            it.dontExist("Sun, Sat")
                        }
                    it.detect("9:00AM")
                        .cell()
                        .onThisElementRegion {
                            it.dontExist("Mon, Tue, Wed, Thu, Fri")
                            it.exist("Sun, Sat")
                        }
                }
            }
            case(2) {
                expectation {
                    it.onCellOf("8:30AM") {
                        it.exist("Mon, Tue, Wed, Thu, Fri")
                        it.dontExist("Sun, Sat")
                    }
                    it.onCellOf("9:00AM") {
                        it.dontExist("Mon, Tue, Wed, Thu, Fri")
                        it.exist("Sun, Sat")
                    }
                }
            }
        }
    }

}