package com.prado.compose.ui.components

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.LocalTextStyle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.prado.compose.R
import com.prado.compose.ui.theme.ArsenalTheme


@Composable
fun ArsenalCircularProgressIndicator(
    modifier: Modifier,
    @StringRes progressTextId: Int = R.string.loading,
    progressTextStyle: TextStyle = LocalTextStyle.current
){
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.padding(top = 12.dp))
        CircularProgressIndicator()
        Text(
            modifier = Modifier,
            text = stringResource(id = progressTextId),
            style = progressTextStyle,
        )
        Spacer(modifier = Modifier.padding(bottom = 12.dp))

    }
}

@Preview
@Composable
fun CircularProgressIndicatorLightPreview(){
    ArsenalTheme(useDarkTheme = false) {
        ArsenalCircularProgressIndicator(modifier = Modifier)
    }
}
@Preview
@Composable
fun CircularProgressIndicatorDarkPreview(){
    ArsenalTheme(useDarkTheme = true) {
        ArsenalCircularProgressIndicator(modifier = Modifier)
    }
}