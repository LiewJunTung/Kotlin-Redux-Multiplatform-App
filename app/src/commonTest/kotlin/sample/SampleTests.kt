package sample

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.test.expect

class SampleTests {
    @Test
    fun testMe() {
        assertTrue(Sample().checkMe() > 0)
    }

    @Test
    fun testProxy() {
        assertTrue(Proxy().proxyHello().isNotEmpty())
    }


}
