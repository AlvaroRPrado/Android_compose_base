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
import androidx.navigation.compose.rememberNavController
import com.prado.compose.navigation.RootNavigationGraph
import com.prado.compose.ui.theme.ArsenalTheme
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

 //        HomeScreen(this)

//         Welcome()

//         HelloWorld()

 //        SaveState(viewModel)

         ComplexNavigationGraph()

//         Hoisting(saveableViewModel)

//          LazyColumnScreen()

//          LazyColumnAnimatedScreen()

//          SearcheableTopBarScreen(searchViewModel)

//          ProfileImageScreen()

//          ProfileRowScreen()

//          SimpleCardScreen()

//          GridViewScreen()

//          BottomNavScreen()

//          SplashScreen()

//          DrawerScreen()

//          FullScreenMessageDialog()

//          FullScreenMsgDialogWithState()

//          FullScreenMsgDialogWithSaveable()


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
private fun Welcome() {
    ComposeArsenalTheme {
        WelcomeView(LocalContext.current)
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "UnusedMaterialScaffoldPaddingParameter")
@Composable
private fun SaveState(viewModel: ObserveStateViewModel) {
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
private fun ComplexNavigationGraph(){
    ArsenalTheme {
        RootNavigationGraph(navController = rememberNavController())
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