# NavButtonsApp

Android app showcasing a [Floating Action Button](https://m2.material.io/components/buttons-floating-action-button) with an exploding animation into submenu buttons, done with Jetpack Compose.

## Framework
### 
- Kotlin + Kotlin DSL
- JDK 17
- Jetpack Compose
- Jetpack Navigation
- Gradle version catalogs
- Google Material3
- Detekt, Spotless

### Architecture (foundation only)
- MVVM, ViewModel
- DI with Hilt

### Testing (TBD)
- JUnit4
- Espresso

> **Note** 
> Jetpack Compose seems to have issues with gesture and pointer tracking. Need to implement a hack to support tracking pointer events from one Composable (menu button) to the other (action buttons). Potentially related Google issues [192479655](https://issuetracker.google.com/issues/192479655), [192479655](https://issuetracker.google.com/issues/192479655), [185228754](https://issuetracker.google.com/issues/185228754), [284987363](https://issuetracker.google.com/issues/284987363)

## Demo
![demo_nav](https://github.com/eveey/NavButtons/assets/33784277/330902da-2a2f-4dbf-a4e3-b00b675d38b8)
