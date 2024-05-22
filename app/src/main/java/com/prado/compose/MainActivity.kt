package com.prado.compose

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.DrawerValue
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.*
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberDrawerState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.prado.compose.ui.theme.ComposeArsenalTheme
import com.prado.compose.ui.views.LoadingView
import com.prado.compose.ui.views.WelcomeView
import com.prado.compose.viewmodel.ObserveStateViewModel


class MainActivity : ComponentActivity() {

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ObserveStateViewModel()
        viewModel.seteLoadingState(true)
        setContent {

            // VideoWelcome()
            VideoSaveState(viewModel)



//          Video: https://youtu.be/73jIHwk-Td0
         // VideoWelcome()

//          Video: https://youtu.be/5031eqGD4xU
//          VideoHelloWorld()

//          Video: https://youtu.be/kuwZX2fSj5A
 //         VideoSaveState(viewModel)

//          Video: https://youtu.be/UJpwxg4tv_U
//          VideoComplexNavigationGraph()

//          https://youtu.be/Cb9_STKO3TU
//          VideoHoisting(saveableViewModel)

//          Video: https://youtu.be/LgqTeJTZ4c8
//          LazyColumnScreen()

//          https://youtu.be/5kSvGOrfcu0
//          LazyColumnAnimatedScreen()

//          https://youtu.be/jYJKX_7l9H4
//          SearcheableTopBarScreen(searchViewModel)

//          https://youtu.be/oSg6HDmUo1w
//          ProfileImageScreen()

//          https://youtu.be/iEk0CCMy8Lg
//          ProfileRowScreen()

//          https://youtu.be/UtjF2t_Y2GA
//          SimpleCardScreen()

//          https://youtu.be/A8lVGNqx9w8
//          GridViewScreen()

//          https://youtu.be/aQlcHIFAfVM
//          HomeScreen()

//          https://youtu.be/aQlcHIFAfVM
//          BottomNavScreen()

//          https://youtu.be/Y3VeuG3jWHo
//          SplashScreen()

//          https://youtu.be/xxxxxxx
//          DrawerScreen()

//          https://youtu.be/xxxxxxx
//          FullScreenMessageDialog()

//          https://youtu.be/xxxxxxx
//          FullScreenMsgDialogWithState()

//          https://youtu.be/xxxxxxx
//            FullScreenMsgDialogWithSaveable()
           /* ComposeArsenalTheme {
                val scaffoldState = rememberScaffoldState(rememberDrawerState(DrawerValue.Closed))

                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        TopAppBar(
                            title ={ Text(text = "Home")})},

                    floatingActionButtonPosition = FabPosition.End,
                    floatingActionButton = { FloatingActionButton(onClick = {}) {
                      Text(text = "+")
                    }},
                    drawerContent =  { Text(text = "Configurações")},
                    content = { HomeScreen(this)},
                    bottomBar = { BottomAppBar() { Text(text = "Barra de Navegação")}}
                )
            }*/
        }
    }
}



@Composable
fun HomeScreen(context: Context){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Greeting(name = "Compose")
        TextButton {
            Toast.makeText(context, "Hello", Toast.LENGTH_SHORT).show()

        }


    }
}
@Composable
private fun VideoWelcome() {
    ComposeArsenalTheme {
        WelcomeView(LocalContext.current)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun VideoSaveState(viewModel: ObserveStateViewModel) {
    ComposeArsenalTheme {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Home") },
                    backgroundColor = MaterialTheme.colorScheme.onSecondary
                )
            },
            floatingActionButtonPosition = FabPosition.End,
            floatingActionButton = {
                FloatingActionButton(onClick = {}) {
                    Text("+")
                }
            },
            content = { LoadingView( viewModel)  }, // Video: https://youtu.be/kuwZX2fSj5A
            bottomBar = { BottomAppBar { Text("Barra de Navegação") } }
        )
    }
}

@Composable
fun HomeView(context: Context) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Greeting(name = "Compose")
        TextButton {
            Toast.makeText(context, "hello", Toast.LENGTH_SHORT).show()
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!"
    )
}

@Composable
fun TextButton(clickAction: () -> Unit) {
    Button(onClick = clickAction) {
        Text(text = "Click Me!")
        
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeArsenalTheme {
        Greeting("Android")
    }
}