package com.example.mvvm_c.presentation.register

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

//ViewModel de la pantalla de registro
class RegisterViewModel : ViewModel() {

    //Lo que escribe el usuario
    var nombre by mutableStateOf("")
    var correo by mutableStateOf("")
    var contrasena by mutableStateOf("")

    //Errores de cada campo
    var errorNombre by mutableStateOf("")
    var errorCorreo by mutableStateOf("")
    var errorContrasena by mutableStateOf("")

    //Poner en true cuando ya se registro
    var registroExitoso by mutableStateOf(false)

    fun onNombreChange(valor: String) {
        nombre = valor
        errorNombre = ""
        registroExitoso = false
    }

    fun onCorreoChange(valor: String) {
        correo = valor
        errorCorreo = ""
        registroExitoso = false
    }

    fun onContrasenaChange(valor: String) {
        contrasena = valor
        errorContrasena = ""
        registroExitoso = false
    }

    //Revisa que los campos esten bien
    fun registrar() {
        errorNombre = if (nombre.isBlank()) "Escribe tu nombre" else ""
        errorCorreo = if (correo.contains("@")) "" else "Escribe un correo valido"
        errorContrasena = if (contrasena.length >= 6) "" else "La contraseña necesita 6 caracteres"

        registroExitoso = errorNombre.isEmpty() &&
                errorCorreo.isEmpty() &&
                errorContrasena.isEmpty()
    }
}
