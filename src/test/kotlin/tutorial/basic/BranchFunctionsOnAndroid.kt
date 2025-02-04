package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.branchextension.*
import shirates.core.vision.driver.commandextension.describe
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest

class BranchFunctionsOnAndroid : VisionTest() {

    @Test
    @Order(10)
    fun branch_platform_device() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    android {
                        virtualDevice {
                            describe("This is called on android emulator")
                        }
                        realDevice {
                            describe("This is called on android real device")
                        }
                    }
                    ios {
                        virtualDevice {
                            describe("This is called on iOS simulator")
                        }
                        realDevice {
                            describe("This is called on iOS real device")
                        }
                    }
                }.expectation {
                    it.screenIs("[Android Settings Top Screen]")
                }
            }
            case(2) {
                action {
                    emulator {
                        describe("This is called on android emulator")
                    }
                    simulator {
                        describe("This is called on iOS simulator")
                    }
                    realDevice {
                        describe("This is called on real device")
                    }
                }.expectation {
                    it.screenIs("[Android Settings Top Screen]")
                }
            }
        }
    }

}