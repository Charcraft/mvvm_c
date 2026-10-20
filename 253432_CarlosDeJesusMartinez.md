# Carlos de Jesús Martinez

- **Matrícula:** 253432
- **Correo:** 253432@it2id.upchiapas.edu.mx
- **GitHub:** https://github.com/Charcraft
- **Rama de trabajo:** `feat/253432-v2` (creada desde `feat/develop`)

## Actividad: Pantalla de registro (MVVM)

Pantalla de registro de usuario con los elementos pedidos:

- Título: "Crear cuenta"
- Icono: `ic_person_add` (y los iconos `ic_email`, `ic_lock` de los campos)
- Campos de texto: nombre, correo electrónico y contraseña
- Botón principal: "Registrarse"
- Apartado "Datos del alumno" con mi nombre completo y mi matrícula

### Archivos que agregué

| Archivo | Para qué sirve |
| --- | --- |
| `app/src/main/java/com/example/mvvm_c/presentation/register/RegisterScreen.kt` | La **View**: dibuja la pantalla y manda lo que escribe el usuario al ViewModel. |
| `app/src/main/java/com/example/mvvm_c/presentation/register/RegisterViewModel.kt` | El **ViewModel**: guarda los datos de los campos y valida el formulario. |
| `app/src/main/res/drawable/ic_person_add.xml` | Icono de persona con "+" (imagen de la pantalla y del campo nombre). |
| `app/src/main/res/drawable/ic_email.xml` | Icono de correo (dentro del campo correo). |
| `app/src/main/res/drawable/ic_lock.xml` | Icono de candado (dentro del campo contraseña). |

### Archivos que modifiqué

| Archivo | Qué cambié |
| --- | --- |
| `app/src/main/res/values/strings.xml` | Agregué los textos de la pantalla de registro. |
| `app/src/main/java/com/example/mvvm_c/navigation/AppNavigation.kt` | Agregué la ruta `registro` y la puse como pantalla de inicio. |
| `gradle/libs.versions.toml` | Agregué la librería `androidx.lifecycle:lifecycle-viewmodel-compose`. |
| `app/build.gradle.kts` | Agregué esa misma librería a las dependencias. |

### Cómo se usa el MVVM aquí

1. El usuario escribe en un campo → la pantalla manda el texto al ViewModel.
2. El ViewModel guarda el dato y borra el error de ese campo.
3. Al presionar **Registrarse** el ViewModel revisa nombre, correo y contraseña.
4. El ViewModel devuelve el resultado (errores o éxito) y la pantalla solo lo muestra.
