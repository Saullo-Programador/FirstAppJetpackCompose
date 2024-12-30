package com.example.firstapp.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firstapp.R
import com.example.firstapp.ui.components.InputComponents

@Composable
fun SignUpScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ){
        FromSignUpScreen()
    }
}

@Composable
fun FromSignUpScreen(){
    val (user, setUser) = remember { mutableStateOf("") }
    val (password, setPassword) = remember { mutableStateOf("") }
    val (isError, setIsError) = remember { mutableStateOf(false) }
    var mostrar by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
    ) {
        InputComponents(
            value = user,
            onValueChange = {
                setUser(it)
                setIsError(it.isEmpty())
            },
            label = "Usuário",
            placeholder = "Digite seu usuário...",
            modifier = Modifier.padding(vertical = 4.dp),
            isError = isError,
            errorMessage = if (isError) "Campo obrigatório" else null,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {}
            ),
            leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
            trailingIcon = {
                if (user.isNotEmpty()) {
                    IconButton(onClick = { setUser("") }) {
                        Icon(Icons.Default.Clear, contentDescription = null)
                    }
                }
            }
        )
        InputComponents(
            value = password,
            onValueChange = {
                setPassword(it)
            },
            label = "Senha",
            placeholder = "Digite sua senha...",
            modifier = Modifier.padding(vertical = 4.dp),
            isError = isError,
            errorMessage = if (isError) "Campo obrigatório" else null,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Password,
                imeAction = ImeAction.Done
            ),
            visualTransformation = if(mostrar) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardActions = KeyboardActions(
                onDone = {}
            ),
            leadingIcon = { Icon(Icons.Default.Lock, contentDescription = null) },
            trailingIcon = {
                IconButton(onClick = {mostrar = !mostrar}) {
                    val icon = if (mostrar) R.drawable.icon_visibility_off else R.drawable.icon_visibility
                    Icon(painterResource(icon), contentDescription = null)
                }
            }
        )
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewSignUpScreen(){
    SignUpScreen()
}