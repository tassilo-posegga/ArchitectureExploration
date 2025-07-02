pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "ArchitectureExploration"
include(":app")
include(":core:ui")
include(":core:network")
include(":core:data")
include(":feature:home:api")
include(":feature:home")
include(":feature:profile:api")
include(":feature:profile")
include(":feature:vehicle:api")
include(":feature:vehicle")
include(":feature:climatisation:api")
include(":feature:climatisation")
include(":feature:range:api")
include(":feature:range")
