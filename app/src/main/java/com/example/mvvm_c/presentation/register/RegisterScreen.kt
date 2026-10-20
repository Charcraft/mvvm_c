package com.example.mvvm_c.presentation.register

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mvvm_c.R
import com.example.mvvm_c.ui.theme.Mvvm_cTheme

//Pantalla de registro
@Composable
fun RegisterScreen(
    viewModel: RegisterViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        //Icono
        Icon(
            painter = painterResource(id = R.drawable.ic_person_add),
            contentDescription = stringResource(id = R.string.registro_icono),
            modifier = Modifier.size(48.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Textos
        Text(
            text = stringResource(id = R.string.registro_titulo),
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = stringResource(id = R.string.registro_subtitulo),
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Campo de texto del nombre
        OutlinedTextField(
            value = viewModel.nombre,
            onValueChange = viewModel::onNombreChange,
            label = { Text(text = stringResource(id = R.string.registro_nombre)) },
            isError = viewModel.errorNombre.isNotEmpty(),
            supportingText = {
                if (viewModel.errorNombre.isNotEmpty()) {
                    Text(text = viewModel.errorNombre)
                }
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        //Campo de texto del correo
        OutlinedTextField(
            value = viewModel.correo,
            onValueChange = viewModel::onCorreoChange,
            label = { Text(text = stringResource(id = R.string.registro_correo)) },
            isError = viewModel.errorCorreo.isNotEmpty(),
            supportingText = {
                if (viewModel.errorCorreo.isNotEmpty()) {
                    Text(text = viewModel.errorCorreo)
                }
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(8.dp))

        //Campo de texto de la contraseña
        OutlinedTextField(
            value = viewModel.contrasena,
            onValueChange = viewModel::onContrasenaChange,
            label = { Text(text = stringResource(id = R.string.registro_contrasena)) },
            isError = viewModel.errorContrasena.isNotEmpty(),
            supportingText = {
                if (viewModel.errorContrasena.isNotEmpty()) {
                    Text(text = viewModel.errorContrasena)
                }
            },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        //Boton principal
        Button(
            onClick = viewModel::registrar,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = stringResource(id = R.string.registro_boton))
        }

        //Mensaje de exito
        if (viewModel.registroExitoso) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = stringResource(id = R.string.registro_exito),
                color = MaterialTheme.colorScheme.primary
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        //Datos del alumno
        Text(
            text = stringResource(id = R.string.registro_datos_alumno),
            style = MaterialTheme.typography.titleSmall
        )

        Text(
            text = stringResource(id = R.string.registro_nombre_alumno),
            style = MaterialTheme.typography.bodySmall
        )

        Text(
            text = stringResource(id = R.string.registro_matricula),
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview(showBackground = true)
@Composable
fun RegisterScreenPreview() {
    Mvvm_cTheme {
        RegisterScreen(viewModel = RegisterViewModel())
    }
}
