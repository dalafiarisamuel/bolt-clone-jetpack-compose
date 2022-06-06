package ng.devtamuno.bolt.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import ng.devtamuno.bolt.compose.ui.component.drawer.NavigationDrawer
import ng.devtamuno.bolt.compose.ui.theme.BoltComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen()

        setContent {
            BoltComposeTheme {
                // A surface container using the 'background' color from the theme
                val scaffoldState = rememberScaffoldState()

                Scaffold(
                    scaffoldState = scaffoldState,
                    drawerGesturesEnabled = true,
                    drawerContent = {
                        NavigationDrawer()
                    }) {
                    it
                }
            }
        }
    }
}
