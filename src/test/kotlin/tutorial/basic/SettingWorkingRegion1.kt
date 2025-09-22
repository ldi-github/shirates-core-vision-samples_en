package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.logging.printInfo
import shirates.core.utility.time.StopWatch
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class SettingWorkingRegion1 : VisionTest() {

    @Test
    @Order(10)
    fun settingWorkingRegion() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.expectation {
                    onTopRegion(topRate = 0.35) {
                        it.exist("Search settings")
                        it.dontExist("Storage")
                    }
                }
            }
            case(2) {
                expectation {
                    onBottomRegion {
                        it.dontExist("Search settings")
                        it.exist("Storage")
                    }
                }
            }
            case(3) {
                expectation {
                    onMiddleRegion(upperRate = 0.1, lowerRate = 0.2) {
                        it.dontExist("Search settings")
                        it.exist("Apps")
                        it.exist("Notifications")
                    }
                }
            }
            case(4) {
                expectation {
                    val v = detect("Search settings")
                    val r = v.rect
                    onRegion(left = r.left, top = r.top, right = r.right, bottom = r.bottom) {
                        it.exist("Search settings")
                    }
                }
            }
            case(5) {
                expectation {
                    onUpperHalfRegion {
                        it.exist("Search settings")
                        it.dontExist("Storage")
                    }
                }
            }
            case(6) {
                expectation {
                    onLowerHalfRegion {
                        it.dontExist("Search settings")
                        it.exist("Storage")
                    }
                }
            }
            case(7) {
                expectation {
                    onLeftHalfRegion {
                        it.existImage("[Network & internet Icon]")
                    }
                }
            }
            case(8) {
                expectation {
                    onRightHalfRegion {
                        it.dontExistImage("[Network & internet Icon]")
                    }
                }
            }
        }
    }

    @Test
    @Order(20)
    fun measureTime() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.action {
                    val sw = StopWatch("Full Screen")
                    it.findImage("[Network & internet Icon]")
                    s1 = "Full Screen:       ${sw.elapsedSeconds} sec"
                }
            }
            case(2) {
                action {
                    val sw = StopWatch("onUpperHalfRegion")
                    onUpperHalfRegion {
                        it.findImage("[Network & internet Icon]")
                    }
                    s2 = "onUpperHalfRegion: ${sw.elapsedSeconds} sec"
                }
            }
            case(3) {
                action {
                    val sw = StopWatch("onBottomRegion")
                    onBottomRegion {
                        it.findImage("[Storage Icon]")
                    }
                    s3 = "onBottomRegion:    ${sw.elapsedSeconds} sec"
                }
            }

            printInfo(s1)
            printInfo(s2)
            printInfo(s3)
        }
    }

}