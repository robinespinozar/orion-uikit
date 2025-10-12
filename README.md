# Orion UI Kit 🌟

Una librería moderna de componentes UI personalizados para **Jetpack Compose**, diseñada para acelerar el desarrollo de aplicaciones Android con componentes reutilizables y estilizados.

## 📋 Características

- ✨ Componentes UI personalizados para Jetpack Compose
- 🎨 Botones custom con diferentes estilos
- 📝 TextFields personalizados
- 🧩 Múltiples componentes listos para usar
- 🚀 Fácil integración con JitPack
- 📱 Compatible con Material 3

## 🛠️ Instalación

### Paso 1: Agregar el repositorio JitPack

Agrega el repositorio de JitPack en tu archivo `settings.gradle.kts` al final de repositories:

```kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
```

### Paso 2: Agregar la dependencia

Agrega la dependencia en el archivo `build.gradle.kts` de tu módulo app:

```kotlin
dependencies {
    implementation("com.github.robinespinozar:orion-uikit:Tag")
}
```

> **Nota:** Reemplaza `Tag` con la versión específica que deseas usar (ejemplo: `1.0.0`) o usa `main-SNAPSHOT` para la última versión del branch main.

## 📦 Requisitos

- **Android minSdk:** 24
- **Android compileSdk:** 36
- **Kotlin:** Compatible con las últimas versiones
- **Jetpack Compose:** Incluido automáticamente

## 🚀 Uso Básico

```kotlin
import com.raerossi.orion.ui_kit.*

@Composable
fun MyScreen() {
    // Usa los componentes de Orion UI Kit
    // Ejemplo de uso aquí
}
```

## 📝 Componentes Disponibles

Esta librería incluye diversos componentes personalizados:

- **Botones personalizados** - Diferentes estilos y variantes
- **TextFields** - Campos de texto con estilos personalizados
- **Y más componentes...** - En constante desarrollo

## 🤝 Contribuciones

Las contribuciones son bienvenidas. Por favor:

1. Haz fork del proyecto
2. Crea una rama para tu feature (`git checkout -b feature/AmazingFeature`)
3. Commit tus cambios (`git commit -m 'Add some AmazingFeature'`)
4. Push a la rama (`git push origin feature/AmazingFeature`)
5. Abre un Pull Request

## 📄 Licencia

Este proyecto está bajo licencia MIT - ver el archivo LICENSE para más detalles.

## 👤 Autor

**Robin Espinoza**
- GitHub: [@robinespinozar](https://github.com/robinespinozar)

## 🔗 Links Útiles

- [Documentación de JitPack](https://jitpack.io/docs/)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Material 3](https://m3.material.io/)

---

⭐️ Si este proyecto te ha sido útil, considera darle una estrella en GitHub!