# NavButtonsApp

A demo app showcasing an expandable [FAB](https://m2.material.io/components/buttons-floating-action-button) (Floating Action Button with a Material 2 style), along with an exploding animation and sub-actions in Jetpack Compose.

- Kotlin + Kotlin DSL
- Jetpack Compose
- Jetpack Navigation
- Gradle version catalogs
- Google Material3
- Detekt, Spotless

(Foundation only)
- ViewModel
- DI with Hilt

### Gesture issue
- Compose has issues with gesture and pointer detection
- TBD: implement a hack to support tracking pointer event from one Composable (menu button) to the other (action buttons)
- Possibly related issues:
https://issuetracker.google.com/issues/192479655
https://issuetracker.google.com/issues/192479655
https://issuetracker.google.com/issues/185228754
https://issuetracker.google.com/issues/284987363

## Demo
![video_demo](https://github.com/eveey/NavButtons/assets/33784277/1fb86f01-4ef9-4843-869c-de825f522cf7)
