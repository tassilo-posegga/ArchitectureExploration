# Project Guidelines - Architecture Exploration

This document outlines the development guidelines and architectural principles for the Architecture Exploration Android project.

## Architecture & Tech Stack

### Core Architecture
- **Clean Architecture** with **MVVM** pattern
- Use **State flows** for reactive programming and state management
- **Jetpack Compose** for UI development
- **Compose Navigation** for navigation between screens
- **Koin** for Dependency Injection
- **Retrofit** for network communication
- **Kotlinx Serialization** for JSON parsing

### Modularization Strategy

#### Module Structure
- **Feature Modules**: Create dedicated modules for each feature (e.g., `:feature:home`, `:feature:profile`, `:feature:favorites`)
- **API Modules**: Each feature should expose its Composables through a dedicated API module (e.g., `:feature:home:api`)
- **Core Modules**: Shared functionality in core modules (e.g., `:core:network`, `:core:data`, `:core:ui`)
- **App Module**: The main `:app` module is the only module that should know about internal feature modules for DI setup

#### Module Dependencies
```
:app
├── :feature:home:api
├── :feature:profile:api  
├── :feature:favorites:api
└── :core:*

:feature:home
├── :feature:home:api
├── :core:network
├── :core:data
└── :core:ui

:feature:home:api
└── :core:ui (for base Composables)
```

#### Composable Exposure Rules
- Feature modules should **only** expose Composables through their dedicated API modules
- Composables can be either:
  - **Screen Composables**: Full screen implementations
  - **Component Composables**: Reusable UI fragments/components
- Internal implementation details should remain private within feature modules

### Development Practices

#### State Management
- Use **StateFlow** and **SharedFlow** for reactive state management
- Implement **ViewModel** with proper lifecycle awareness
- Use **Compose State** for UI-specific state

#### Navigation
- Use **Compose Navigation** for screen transitions
- Define navigation graphs in feature API modules
- Implement type-safe navigation arguments

#### Dependency Injection
- Configure **Koin** modules in the `:app` module only
- Feature modules should provide their own Koin modules
- Use constructor injection for ViewModels and repositories

#### Network & Data
- Use **Retrofit** with **Kotlinx Serialization** for API calls
- Implement Repository pattern for data access
- Use **Room** database for local storage when needed

### Testing Guidelines
- Write unit tests for ViewModels, Repositories, and Use Cases
- Use **Compose Testing** for UI tests
- Mock dependencies using **Mockk** or similar
- Junie should run tests to verify correctness of proposed solutions
- Build the project before submitting results to ensure compilation

### Code Style
- Follow **Kotlin Coding Conventions**
- Use **ktlint** for code formatting
- Prefer **sealed classes** for state representations
- Use **data classes** for immutable data structures
- Apply **single responsibility principle** in all layers

### Project Structure Example
```
app/
├── src/main/java/
│   └── eu/aggesop/architectureexploration/
│       ├── MainActivity.kt
│       ├── ArchitectureExplorationApplication.kt
│       └── di/
│           └── AppModule.kt

feature/
├── home/
│   ├── api/
│   │   └── src/main/java/.../home/api/
│   │       └── HomeScreenApi.kt
│   └── src/main/java/.../home/
│       ├── presentation/
│       │   ├── HomeViewModel.kt
│       │   └── HomeScreen.kt
│       ├── domain/
│       │   └── HomeRepository.kt
│       └── di/
│           └── HomeModule.kt

core/
├── network/
├── data/
├── ui/
└── common/
```

### Migration Strategy
When refactoring existing code:
1. Start by extracting feature modules
2. Create API modules for each feature
3. Move Composables to appropriate modules
4. Update dependency injection configuration
5. Ensure proper separation of concerns
