package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ExistImageDontExistImage1 : VisionTest() {

    @Test
    @Order(10)
    fun existImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.existImage("[Apps Icon]")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun withScrollDown_existImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.existImage("[System Icon]")
                    }
                }
            }
        }
    }

    @Test
    @Order(30)
    fun withScrollDown_existImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .existImage("[Network & internet Icon]")
                        .scrollDown()
                }.expectation {
                    withScrollDown {
                        it.existImage("[Network & internet Icon]")
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun withScrollDown_existImageWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.existImageWithoutScroll("[Network & internet Icon]")     // OK
                        it.existImageWithoutScroll("[System Icon]")     // NG
                    }
                }
            }
        }
    }

    @Test
    @Order(40)
    fun dontExistImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.dontExistImage("[System Icon]")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun withScrollDown_dontExistImage_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.dontExistImage("[VPN Icon]")
                    }
                }
            }
        }
    }

    @Test
    @Order(50)
    fun withScrollDown_dontExistImage_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.dontExistImage("[System Icon]")
                    }
                }
            }
        }
    }

    @Test
    @Order(60)
    fun withScrollDown_dontExistImageWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.dontExistWithoutScroll("Accessibility")    // OK
                        it.dontExistWithoutScroll("Notifications")    // NG
                    }
                }
            }
        }
    }

}