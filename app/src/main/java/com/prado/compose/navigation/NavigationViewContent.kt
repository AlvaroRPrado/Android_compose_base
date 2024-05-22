package com.prado.compose.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.prado.compose.ui.components.BottomBar
import com.prado.compose.ui.theme.ArsenalTheme
import com.prado.compose.ui.theme.ArsenalThemeExtended

// 2) DEFINIR CONTEUDOS DAS TELAS
@Composable
fun ViewContent(name: String, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ){
        Text(
            modifier = Modifier.clickable { onClick() },
            text = name,
            fontSize = ArsenalThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
fun ViewContentPreview(){
    ArsenalTheme(useDarkTheme = false) {
        ViewContent("Conteúdo que exibirei"){}
    }
}

@Composable
fun LoginContent(
    onLonginClick: () -> Unit,
    onSignupClick: () -> Unit,
    onForgotClick: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.clickable { onLonginClick() },
            text = "Login",
            fontSize = ArsenalThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            modifier = Modifier.clickable { onSignupClick() },
            text = "Sign up",
            fontSize = ArsenalThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Medium
        )
        Text(
            modifier = Modifier.clickable { onForgotClick() },
            text = "Forgot password",
            fontSize = ArsenalThemeExtended.typography.h1.fontSize,
            fontWeight = FontWeight.Medium
        )

    }

}
@Preview
@Composable
fun LoginContentPreview(){
    ArsenalTheme(useDarkTheme = false) {
        LoginContent({ }, { }) {
            
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeViewContent(navController: NavHostController = rememberNavController()){
    Scaffold(
        bottomBar = { BottomBar(navController = navController) }
    ) {
        HomeNavGraph(navController = navController)
    }
}

@Preview
@Composable
fun HomeViewContentPreview(){
    ArsenalTheme {
        HomeViewContent(rememberNavController())
    }
}