package tutorial.basic

import org.junit.jupiter.api.Test
import shirates.core.testcode.ios
import shirates.core.vision.driver.commandextension.appIs
import shirates.core.vision.driver.commandextension.launchApp
import shirates.core.vision.driver.commandextension.terminateApp
import shirates.core.vision.testcode.VisionTest

@ios
class LaunchApp2 : VisionTest() {

    @Test
    fun launchApp() {

        scenario {
            case(1) {
                condition {
                    it.terminateApp()
                }.action {
                    it.launchApp()
                }.expectation {
                    it.appIs("Settings")
                }
            }
            case(2) {
                condition {
                    it.terminateApp("[Safari]")
                }.action {
                    it.launchApp("[Safari]")
                }.expectation {
                    it.appIs("[Safari]")
                }
            }
            case(3) {
                condition {
                    it.terminateApp("com.apple.mobilesafari")
                }.action {
                    it.launchApp("com.apple.mobilesafari")
                }.expectation {
                    it.appIs("com.apple.mobilesafari")
                }
            }
            case(4) {
                condition {
                    it.terminateApp("Safari")
                }.action {
                    it.launchApp("Safari")
                }.expectation {
                    it.appIs("Safari")
                }
            }
            case(5) {
                condition {
                    it.terminateApp("[Maps]")
                }.action {
                    it.launchApp("[Maps]")
                }.expectation {
                    it.appIs("[Maps]")
                }
            }
        }
    }

}