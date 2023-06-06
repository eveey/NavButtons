# NavButtonsApp

A demo app showcasing an expandable [FAB](https://m2.material.io/components/buttons-floating-action-button) (Floating Action Button with a Material 2 style), along with an exploding animation and sub-actions in Jetpack Compose.

## Framework
### 
- Kotlin + Kotlin DSL
- JDK 17
- Jetpack Compose
- Jetpack Navigation
- Gradle version catalogs
- Google Material3
- Detekt, Spotless

### Architecture MVVM (foundation only)
- ViewModel
- DI with Hilt

### Testing (TBD)
- JUnit4
- Espresso

> **Note** 
> Jetpack Compose seems to have issues with gesture and pointer tracking. Need to implement a hack to support tracking pointer event from one Composable (menu button) to the other (action buttons). Potentially related Google issues [192479655](https://issuetracker.google.com/issues/192479655), [192479655](https://issuetracker.google.com/issues/192479655), [185228754](https://issuetracker.google.com/issues/185228754), [284987363](https://issuetracker.google.com/issues/284987363)

## Demo
![demo](https://github.com/eveey/NavButtons/assets/33784277/d6924a75-0241-42c7-83cc-34cb5e98262e)
