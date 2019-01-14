package sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlin.reflect.KClass


fun activityScreen(screen: String): KClass<*>? {
    return when(screen){
        ActivityState.MAIN -> MainActivity::class
        ActivityState.LOGIN -> LoginActivity::class
        else -> null
    }
}


class SplashScreen: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val jsonApp = assets.open("app.json")
        ApplicationStore.activityStore.subscribe {
            startNewActivity()
        }
        initJAppState(String(jsonApp.readBytes()))
    }

    fun startNewActivity(){
        val actions = ApplicationStore.activityStore.state.actions
        val nextScreen = actions["login_screen"]
        val ns = nextScreen!!.params["next_screen"]
        Toast.makeText(this, nextScreen.toString(), Toast.LENGTH_LONG).show()
        val intent = Intent(this, activityScreen(ns!!)?.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        startActivity(intent)
    }
}

