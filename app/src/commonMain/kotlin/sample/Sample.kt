package sample

import com.liewjuntung.redux.api.Reducer
import com.liewjuntung.redux.createStore
import kotlinx.serialization.json.JSON


expect class Sample() {
    fun checkMe(): Int
}

expect object Platform {
    val name: String
}

fun hello(): String = "Hello from ${Platform.name}"

class Proxy {
    fun proxyHello() = hello()
}

object ApplicationStore {
    val appStore = createStore(App.Reducers.APP_REDUCER, JAppState("", "", "", "", listOf()))
    val activityStore = createStore(App.Reducers.ACTIVITY_REDUCER, JScreen(""))
}

fun initJAppState(json: String) {
    val appState = JSON.nonstrict.parse(JAppState.serializer(), json)
    ApplicationStore.appStore.dispatch(App.Action.UpdateState(appState))
    val jscreen = appState.screens.find { appState.initScreen == it.id }
    println("SCREEN: " + jscreen?.toString())
    if (jscreen != null){
        ApplicationStore.activityStore.dispatch(ActivityState.Action.UpdateScreen(jscreen))
    }
}

object ActivityState {
    const val LOGIN = "LOGIN_SCREEN"
    const val MAIN = "MAIN_SCREEN"

    sealed class Action {
        class UpdateScreen(val state: JScreen) : Action()
    }
}

object App {

    sealed class Action {
        class UpdateState(val state: JAppState) : Action()
    }


    object Reducers {
        val ACTIVITY_REDUCER: Reducer<JScreen> = { state: JScreen, action: Any ->
            when (action) {
                is ActivityState.Action.UpdateScreen -> {
                    action.state
                }
                else -> {
                    state
                }
            }
        }
        val APP_REDUCER: Reducer<JAppState> = { state: JAppState, action: Any ->
            when (action) {
                is App.Action.UpdateState -> {
                    action.state
                }
                else -> {
                    state
                }
            }
        }
    }
}
