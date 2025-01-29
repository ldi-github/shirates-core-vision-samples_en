package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class ExistDontExist1 : VisionTest() {

    @Test
    @Order(10)
    fun exist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.exist("Network & internet")
                }
            }
        }
    }

    @Test
    @Order(20)
    fun exist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.exist("System")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun existWithScrollDown_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.existWithScrollDown("System")
                }
            }
        }
    }

    @Test
    @Order(40)
    fun existWithScrollDown_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.existWithScrollDown("Network business")
                }
            }
        }
    }

    @Test
    @Order(50)
    fun existWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickAndGoDown()
                }.expectation {
                    it.existWithScrollUp("Network & internet")
                }
            }
        }
    }

    @Test
    @Order(60)
    fun existWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickAndGoDown()
                }.expectation {
                    it.existWithScrollUp("Network business")
                }
            }
        }
    }

    @Test
    @Order(70)
    fun dontExist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.dontExist("System")
                }
            }
        }
    }

    @Test
    @Order(80)
    fun dontExist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    it.dontExist("Network & internet")
                }
            }
        }
    }

    @Test
    @Order(90)
    fun withScrollDown_dontExist_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.dontExist("Network business")
                    }
                }
            }
        }
    }

    @Test
    @Order(100)
    fun withScrollDown_dontExist_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.dontExist("System")
                    }
                }
            }
        }
    }

    @Test
    @Order(110)
    fun dontExistWithScrollUp_OK() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExist("Network business")
                    }
                }
            }
        }
    }

    @Test
    @Order(120)
    fun dontExistWithScrollUp_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExist("System")
                    }
                }
            }
        }
    }

    @Test
    @Order(130)
    fun withScrollDown_existWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it.existWithoutScroll("Network & internet")    // OK
                        it.existWithoutScroll("System")    // NG
                    }
                }
            }
        }
    }

    @Test
    @Order(140)
    fun withScrollUp_dontExistWithoutScroll_NG() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                        .flickAndGoDown()
                }.expectation {
                    withScrollUp {
                        it.dontExistWithoutScroll("Display")    // OK
                        it.dontExistWithoutScroll("System")    // NG
                    }
                }
            }
        }
    }

}