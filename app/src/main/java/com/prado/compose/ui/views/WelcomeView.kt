package com.prado.compose.ui.views

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prado.compose.R
import com.prado.compose.ui.components.ArsenalButtonRow
import com.prado.compose.ui.components.ArsenalIconImage
import com.prado.compose.ui.theme.ArsenalTheme
import com.prado.compose.ui.theme.ArsenalThemeExtended


// 1) Como estruturar componente (antes de começar) Criar view
// 2) Como usar Column, Rows, Boxes - Criar componentes
// 3) Como deixar seus componentes reusáveis

@Composable
fun WelcomeView(context: Context){
    val action = { Toast.makeText(context, "Olha isso!", Toast.LENGTH_SHORT).show() }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.background(MaterialTheme.colorScheme.background)
    ) {
        Column(//Colunn
            modifier = Modifier
                .weight(weight = 1f)
                .padding(horizontal = 16.dp)
                .padding(top = 16.dp)
        ) {
            Text(
                text = "Compose Arsenal",
                style = ArsenalThemeExtended.typography.h1
            )

            Text(
                text = "Seja bem vindo a tropa!",
                style = ArsenalThemeExtended.typography.body1,
                modifier = Modifier.padding(vertical = 16.dp)
            )

            ArsenalIconImage(R.drawable.ic_airplanemode)

        }


        ArsenalButtonRow( // Row
            modifier = Modifier.widthIn(min = 100.dp, max = 120.dp),
            positiveAction = action,
            positiveTextId = R.string.btn_row_confirm,
            neutralAction = action,
            negativeTextId = R.string.btn_row_maybe,
            negativeAction = action,
            neutrallTextId = R.string.btn_row_cancel

        )

    }

}

@Preview
@Composable
fun WelcomeViewLightPreview() {
    ArsenalTheme(useDarkTheme = false) {
        WelcomeView(LocalContext.current)
    }
}

@Preview
@Composable
fun WelcomeViewDarkPreview() {
    ArsenalTheme(useDarkTheme = true) {
        WelcomeView(LocalContext.current)
    }
}