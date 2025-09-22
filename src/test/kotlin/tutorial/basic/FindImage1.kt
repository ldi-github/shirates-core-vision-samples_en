package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.thisIsTrue
import shirates.core.driver.testContext
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class FindImage1 : VisionTest() {

    @Test
    @Order(10)
    fun findImage() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    withScrollDown {
                        v1 = it.findImage("[Network & internet Icon]")
                        v2 = it.findImage("[Display & touch Icon]")
                    }
                }.expectation {
                    v1.isFound.thisIsTrue("[Network & internet Icon] is found.")
                    v2.isFound.thisIsTrue("[Display & touch Icon] is found.")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun findImageWithScrollDown_findImageWithScrollUp() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    v1 = findImageWithScrollDown("[Location Icon]")
                }.expectation {
                    v1.imageIs("[Location Icon]")
                }
            }
            case(2) {
                action {
                    v1 = findImageWithScrollUp("[Connected devices Icon]")
                }.expectation {
                    v1.imageIs("[Connected devices Icon]")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun findImageWithScrollRight_findImageWithScrollLeft() {

        testContext.segmentMarginHorizontal = 5

        scenario {
            case(1) {
                condition {
                    it.macro("[Files Top Screen]")
                }.action {
                    it.findImage("[Images Button]").onLine {
                        v1 = findImageWithScrollRight("[This week Button]")
                    }
                }.expectation {
                    v1.imageIs("[This week Button]")
                }
            }
            case(2) {
                action {
                    v1.onLine {
                        v2 = findImageWithScrollLeft("[Audio Button]")
                    }
                }.expectation {
                    v2.imageIs("[Audio Button]")
                }
            }
        }
    }

}