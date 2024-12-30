package com.example.firstapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SignInScreen(){
    FromSignInScreen()
}

@Composable
fun FromSignInScreen(){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Sign In")
    }
}

@Preview
@Composable
fun PreviewSignInScreen(){
    SignInScreen()
}