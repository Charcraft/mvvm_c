# MVVM_C — Personajes de Rick and Morty

App Android de ejemplo con arquitectura **MVVM**, **Jetpack Compose** y **Navigation Compose**.
Muestra una lista de personajes en tarjetas; al tocar una tarjeta navega a la pantalla de detalle.

## Requisitos previos (todos los sistemas)

- **Android Studio** (última versión estable) — incluye el JDK necesario (JBR) y el SDK Manager
- **Git** instalado
- El proyecto usa:
  - Gradle **9.6.0** (se descarga solo con el wrapper incluido, no necesitas instalar Gradle)
  - Android Gradle Plugin **9.3.0**
  - Kotlin **2.2.10**
  - **compileSdk / targetSdk 37** — **minSdk 24** (Android 7.0 o superior)

---

## Windows — paso a paso

1. **Instalar Android Studio**
   - Descarga desde https://developer.android.com/studio
   - Ejecuta el instalador y deja marcadas las opciones por defecto (**Android SDK** y **Android Virtual Device** incluidos)

2. **Clonar el repositorio**
   ```powershell
   git clone https://github.com/Charcraft/mvvm_c.git
   ```
   O usa **Download ZIP** desde la página del repo y descomprímelo.

3. **Abrir el proyecto**
   - Abre Android Studio → **Open** → selecciona la carpeta `mvvm_c` (la que contiene `settings.gradle.kts`) → **OK**
   - Si aparece *"Trust project"*, presiona **Trust project**

4. **Esperar el Gradle Sync**
   - La primera vez tarda varios minutos: descarga Gradle 9.6.0, el SDK Platform 37 y las dependencias
   - Android Studio genera automáticamente el archivo `local.properties` con la ruta de tu SDK
   - Si pide instalar el SDK Platform 37 o aceptar licencias, presiona **Install/Accept**

5. **Ejecutar** (elige una opción abajo: emulador, celular o CLI)

---

## macOS — paso a paso

1. **Instalar Android Studio**
   ```bash
   brew install --cask android-studio
   ```
   o descarga el `.dmg` (Apple Silicon o Intel) desde https://developer.android.com/studio

2. **Instalar Git** (si no lo tienes): `brew install git`

3. **Clonar y abrir**
   ```bash
   git clone https://github.com/Charcraft/mvvm_c.git
   ```
   Android Studio → **Open** → carpeta `mvvm_c`

4. **Esperar el Gradle Sync** (igual que en Windows)

5. **Ejecutar** (ver opciones abajo)

---

## Linux — paso a paso

1. **Instalar Android Studio**
   - Ubuntu/Debian: `sudo snap install android-studio --classic`
   - O descarga el `.tar.gz` desde https://developer.android.com/studio, descomprímelo y ejecuta `bin/studio.sh`

2. **Instalar Git**: `sudo apt install git`

3. **Clonar y abrir** (igual que en macOS)

4. **Esperar el Gradle Sync**

5. **Ejecutar** (ver opciones abajo)

---

## Opción A: Ejecutar en emulador

1. En Android Studio: **Tools → Device Manager → Create Virtual Device**
2. Elige un dispositivo (ej. **Pixel 6**) → **Next**
3. Descarga una imagen del sistema (recomendado: la más reciente; mínimo **API 24**) → **Finish**
4. Presiona ▶ **Run 'app'** en la barra superior con el emulador seleccionado

## Opción B: Ejecutar en celular físico

1. En el celular: **Ajustes → Acerca del teléfono** → toca 7 veces **Número de compilación** para activar *Opciones de desarrollador*
2. En **Opciones de desarrollador** activa **Depuración USB**
3. Conecta el celular por USB y **acepta el aviso de autorización** (huella RSA) en la pantalla del celular
4. Verifica que Android Studio lo detecta en el menú desplegable de dispositivos (arriba)
   - *Windows:* si no lo detecta, instala los drivers USB del fabricante (para Samsung: Smart Switch)
   - *Linux:* puede requerir reglas `udev` (`sudo apt install android-sdk-platform-tools-common`)
5. Presiona ▶ **Run 'app'**

## Opción C: Línea de comandos (sin abrir Android Studio)

```bash
# Windows
gradlew.bat installDebug

# macOS / Linux
./gradlew installDebug
```

Requisitos:
- Variable `ANDROID_HOME` apuntando al SDK, **o** archivo `local.properties` en la raíz con `sdk.dir=<ruta-del-sdk>`
- JDK 17+ configurado (`JAVA_HOME`)

Para lanzar la app ya instalada:
```bash
adb shell monkey -p com.example.mvvm_c -c android.intent.category.LAUNCHER 1
```

---

## Solución de problemas

| Problema | Solución |
|---|---|
| *Gradle sync failed* | Actualiza Android Studio a la última versión estable (el proyecto usa AGP 9.3.0) |
| *SDK Platform 37 not found* | **Tools → SDK Manager → SDK Platforms** → marca Android 37 → **Apply** |
| `local.properties` faltante | Abre el proyecto desde Android Studio; se genera solo (no está en el repo porque es local) |
| El celular no aparece | Revisa el cable (que sea de datos), acepta la autorización RSA y corre `adb devices` |
| Pantalla del aviso de licencias | **Tools → SDK Manager → SDK Tools** y acepta licencias, o `sdkmanager --licenses` |

## Estructura del proyecto

```
app/src/main/java/com/example/mvvm_c/
├── MainActivity.kt
├── navigation/AppNavigation.kt          # NavHost: "characters" y "detail"
├── data/model/DataModel.kt              # data class Character
└── presentation/
    ├── character/
    │   ├── CharacterListScreen.kt       # Lista con LazyColumn + Cards
    │   ├── CharacterListViewModel.kt    # StateFlow con datos locales
    │   └── CharacterListUIState.kt      # Estado de la UI
    └── detail/CharacterDetailScreen.kt
```
