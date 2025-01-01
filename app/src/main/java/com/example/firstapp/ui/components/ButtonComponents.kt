package com.example.firstapp.ui.components

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ButtonComponents(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Button(
        onClick = {onClick()},
        modifier = modifier
    ) {
        Text(
            text = text
        )
    }
}

@Preview()
@Composable
fun PreviewButtonComponents(){
    ButtonComponents(
        text = "Text",
        onClick = {}
    )
}