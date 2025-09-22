package tutorial.basic

import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import shirates.core.vision.driver.commandextension.*
import shirates.core.vision.testcode.VisionTest

class Scroll1 : VisionTest() {

    @Test
    @Order(10)
    fun scrollDown_scrollUp() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it
                        .scrollDown()
                        .scrollDown()
                        .scrollUp()
                        .scrollUp()
                }
            }
            case(2) {
                action {
                    it
                        .scrollDown(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollDown(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                        .scrollUp(scrollDurationSeconds = 5.0, startMarginRatio = 0.1)
                        .scrollUp(scrollDurationSeconds = 3.0, startMarginRatio = 0.3)
                }
            }
        }
    }

    @Test
    @Order(20)
    fun scrollToBottom_scrollToTop() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.action {
                    it.scrollToBottom(repeat = 2)
                }.expectation {
                    it.exist("Tips & support")
                }
            }
            case(2) {
                action {
                    it.scrollToTop(repeat = 2)
                }.expectation {
                    it.exist("Google")
                }
            }
        }
    }

    @Test
    @Order(30)
    fun withScroll() {

        scenario {
            case(1) {
                condition {
                    it.macro("[Android Settings Top Screen]")
                }.expectation {
                    withScrollDown {
                        it
                            .detect("Notifications").textIs("Notifications")
                            .detect("Accessibility").textIs("Accessibility")
                            .detect("Tips & support").textIs("Tips & support")
                    }
                    withScrollUp {
                        it
                            .detect("Accessibility").textIs("Accessibility")
                            .detect("Notifications").textIs("Notifications")
                    }
                }
            }
            case(2) {
                expectation {
                    withScrollDown {
                        it
                            .exist("Notifications")
                            .exist("Accessibility")
                            .exist("Tips & support")
                    }
                    withScrollUp {
                        it
                            .exist("Tips & support")
                            .exist("Accessibility")
                            .exist("Notifications")
                    }
                }
            }
            case(3) {
                action {
                    withScrollDown {
                        it.tap("Accessibility")
                    }
                }.expectation {
                    it.screenIs("[Accessibility Screen]")
                }
            }
            case(4) {
                action {
                    it.pressBack()
                    withScrollUp {
                        it.tap("Network & internet")
                    }
                }.expectation {
                    it.screenIs("[Network & internet Screen]")
                }
            }
        }
    }

}