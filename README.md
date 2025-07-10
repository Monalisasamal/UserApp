# Project

This project build with Kotlin Clean Architecture and latest jetpack libraries, 
dependency injection with Hilt, and data handing using Kotlin Retrofit, Coroutines and Flow
project has three screen **Splash Screen**, **User list Screen**, **User Details Screen**

## Screenshots



## Tech Stack

- **Architecture** – Clean Architecture
- **UI** – Jetpack Compose, ViewModel.
- **Data** – Retrofit, Kotlin Flow.
- **DI** – Hilt.
- **Testing** – JUnit, MockK
---

## Features
- **Clean Architecture**
- **Kotlin Coroutines Flow**
- **Retrofit for API calls**
- **Hilt for dependency Injection**
- **Jetpack Navigation**
- **Unit and UI testing with MockK and Junit**
---

## Project Structure

The app follows a **Clean architecture pattern** with the following main modules:

- **core**:  
  Contains shared logic and common utilities for the app.

- **data**:  
  Handles data sources, including local storage, remote APIs, and caching.

- **domain**:  
  Represent the business logic, including use cases and entities.

- **presentation**:  
  Handles the UI using Jetpack Compose to render views and manage user interactions.
- 
---
## Features

- **Jetpack Compose**: Used for modern and declarative UI development.
- **Retrofit**: For seamless API integration.
- **Clean Architecture**: 
  - Separation of concerns across Presentation, Domain, and Data layers.
  - Enhanced reusability, testability, scalability, and maintainability.
- **Dependency Injection**: 
  - Efficient management of modules and initialization of dependencies.
- **Test Cases**:
  - Covers empty, data, and error scenarios for robust implementation.

---

## API Integration

This project uses the following public API for fetching articles:
- **API URL**: [https://dummyjson.com/]

---

## Testing
- **Unit Test**: [./gradlew testDebugUnitTest]



