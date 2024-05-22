package com.prado.compose.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.prado.compose.R
import com.prado.compose.ui.components.ArsenalButton
import com.prado.compose.ui.components.ArsenalCircularProgressIndicator
import com.prado.compose.ui.theme.ArsenalTheme
import com.prado.compose.ui.theme.ArsenalThemeExtended
import com.prado.compose.viewmodel.ObserveStateViewModel

// 1) COMO OBSERVAR ESTADOS EM COMPOSE COM VIEWMODEL
// 2) COMO CRIAR UM COMPONENTE REUTILIZÁVEL PARA LOADING SCREENS
// 3) COMO PASSAR ESTADO PARA COMPOSABLE E COMO ALTERA-LO (LOADING VIEW)
// 4) COMO INSTANCIAR O FLOW NO PREVIEW USANDO VIEW MODEL

@Composable
fun LoadingView(viewModel: ObserveStateViewModel){

    val loading by viewModel.loadingStateFlow.collectAsState()

    when{
        loading -> {
            //ENQUANTO ESTIVER CARREGANDO, EXIBA LOADING COM TEXTO "AGUARDE"
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                ArsenalCircularProgressIndicator(Modifier, R.string.loading)
                ArsenalButton(
                    modifier = Modifier,
                    clickAction = { viewModel.seteLoadingState(false)},
                    textId = R.string.exit_loading
                )
            }
        }
        else ->{
            // DO CONTRARIO EXITA O CONTEUDO DESEJADO...
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Aeeee! Consegui!!!",
                    style = ArsenalThemeExtended.typography.h1,
                )
                ArsenalButton(
                    modifier = Modifier,
                    clickAction = {viewModel.seteLoadingState(true)},
                    textId = R.string.enter_loading )

            }
        }
    }
}

@Preview
@Composable
fun LoadingViewLightPreview() {
    ArsenalTheme(useDarkTheme = false) {
        LoadingView(ObserveStateViewModel().apply {
            loadingStateFlow.value = true
        })
    }
}

@Preview
@Composable
fun LoadingViewDarkPreview() {
    ArsenalTheme(useDarkTheme = true) {
        LoadingView(ObserveStateViewModel().apply {
            loadingStateFlow.value = false
        })
    }
}