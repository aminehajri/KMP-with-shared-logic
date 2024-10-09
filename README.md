# Kotlin Multiplatform News App

This project is an experiment with Kotlin Multiplatform for developing both iOS and Android applications. The goal is to share business logic between the two platforms while implementing their respective user interfaces using Jetpack Compose for Android and SwiftUI for iOS.

## Project Overview

This App demonstrates how to:
- Share common business logic between iOS and Android apps.
- Utilize platform-specific UI frameworks: Jetpack Compose on Android and SwiftUI on iOS.
- Fetch and display news from the [News API](https://newsapi.org/).


## Screenshots

<table>
  <tr>
    <td><img src="https://github.com/user-attachments/assets/8a84e759-8962-4d67-b5d7-b1a896126a1f" alt="iOS Screenshot" width="300"/></td>
    <td><img src="https://github.com/user-attachments/assets/a14cb0bd-ad76-4a3d-9090-4aca482bb9d8" alt="Android Screenshot" width="300"/></td>
  </tr>
  <tr>
    <td align="center">iOS</td>
    <td align="center">Android</td>
  </tr>
</table>



## Libraries and Frameworks

The project leverages several libraries and frameworks to achieve its goals:

### Shared Code
- **Ktor client**: A framework for making asynchronous HTTP requests.
- **Koin**: A dependency injection framework for Kotlin.

### Android Specific
- **Jetpack Compose**: A modern toolkit for building native Android UI.

### iOS Specific
- **SwiftUI**: A declarative framework for building UI on Apple platforms.
- **SKIE**: A library for bridging Kotlin Coroutines with Apple's Combine framework.

## Project Structure

The project is divided into several modules:

- **shared**: Contains the shared business logic written in Kotlin, including networking and data models.
- **androidApp**: Contains the Android-specific code, including the Jetpack Compose UI.
- **iosApp**: Contains the iOS-specific code, including the SwiftUI UI.



