package sample

import kotlinx.serialization.Optional
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class JAppState(
    @SerialName("init_screen") val initScreen: String,
    @SerialName("package_name") val packageName: String,
    @SerialName("server_url") val serverUrl: String,
    @SerialName("app_name") val appName: String,
    val screens: List<JScreen>
)

@Serializable
data class JScreen(val id: String, @Optional val name: String = "", @Optional val actions: Map<String, JAction> = mapOf())

@Serializable
data class JAction(val id: String, val params: Map<String, String>)

