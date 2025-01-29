package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.storage.app
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class App1 : VisionTest() {

    @Test
    @Order(10)
    fun app() {

        scenario {
            case(1) {
                condition {
                    it.launchApp("[Settings]")
                        .tap("Search settings")
                        .screenIs("[Android Settings Search Screen]")
                        .tap("[Search Box]")
                }.action {
                    it.sendKeys(app("[Settings].packageOrBundleId"))
                }.expectation {
                    it.textIs(app("[Settings].packageOrBundleId"))
                }
            }
        }
    }
}