package sample
import org.djinnihello.HWHelloWorld

actual class Sample {
    actual fun checkMe() = 7
}

actual object Platform {
    actual val name: String = "iOS"
}

fun xPrintStuff(): String? {
    val x = HWHelloWorld.create()
    return x?.getHelloWorld()
}
