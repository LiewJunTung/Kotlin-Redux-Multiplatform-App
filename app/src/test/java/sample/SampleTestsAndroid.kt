package sample

import sample.ApplicationStore.store
import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.expect

class SampleTestsAndroid {
    @Test
    fun testHello() {
        assertTrue("Android" in hello())
    }

    @Test
    fun testReduxInitialState() {
        expect(store.state) {
            Main.State(
                Main.Screen.MAIN
            )
        }
    }
}
