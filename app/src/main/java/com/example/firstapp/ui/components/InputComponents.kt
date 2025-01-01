package com.example.firstapp.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun InputComponents(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    modifier: Modifier = Modifier,
    placeholder: String = "",
    isError: Boolean = false,
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    visualTransformation: VisualTransformation? = VisualTransformation.None,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    shape: RoundedCornerShape
) {
    Column(modifier = modifier) {
        if (visualTransformation != null) {
            OutlinedTextField(
                value = value,
                onValueChange = onValueChange,
                label = { Text(text = label) },
                placeholder = { Text(text = placeholder) },
                isError = isError,
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = keyboardOptions,
                keyboardActions = keyboardActions,
                visualTransformation = visualTransformation,
                leadingIcon = leadingIcon,
                trailingIcon = trailingIcon,
                shape = shape
            )
        }
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewInputComponents(){
    val (text, setText) = remember { mutableStateOf("") }
    val (isError, setIsError) = remember { mutableStateOf(false) }

    InputComponents(
        value = text,
        onValueChange = {
            setText(it)
            setIsError(it.isEmpty())
        },
        label = "Nome",
        placeholder = "Digite seu nome",
        isError = isError,
        errorMessage = if (isError) "Campo obrigatório" else null,
        leadingIcon = { Icon(Icons.Default.Person, contentDescription = null) },
        trailingIcon = {
            if (text.isNotEmpty()) {
                IconButton(onClick = { setText("") }) {
                    Icon(Icons.Default.Clear, contentDescription = null)
                }
            }
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Text,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { /* Ação ao pressionar "Done" */ }
        ),
        shape = RoundedCornerShape(20.dp)
    )
}