package tutorial.inaction

import org.junit.jupiter.api.Test
import shirates.core.driver.commandextension.exist
import shirates.core.driver.commandextension.existWithScrollDown
import shirates.core.vision.classicScope
import shirates.core.vision.driver.commandextension.exist
import shirates.core.vision.driver.commandextension.screenIs
import shirates.core.vision.testcode.VisionTest
import shirates.core.vision.visionScope

class UsingClassicAPIsInVisionTest1 : VisionTest() {

    @Test
    fun exactTextMatching() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.expectation {
                    classicScope {
                        it.existWithScrollDown("Tips & support")    // exact match
                    }
                }
            }
        }

    }

    @Test
    fun nestingScopes() {

        scenario {
            case(1) {
                condition {
                    it.screenIs("[Android Settings Top Screen]")
                }.expectation {
                    classicScope {
                        it.existWithScrollDown("Tips & support")    // exact match

                        visionScope {
                            it.exist("Tips & support")  // best effort match

                            classicScope {
                                it.exist("Tips & support")  // exact match
                            }
                        }
                    }
                }
            }
        }

    }
}