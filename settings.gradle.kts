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
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
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
include(":feature:climatisation")
include(":feature:climatisation:api")
include(":feature:climatisation:data")
include(":feature:climatisation:domain")
include(":feature:climatisation:ui")
include(":feature:access")
include(":feature:access:api")
include(":feature:access:data")
include(":feature:access:domain")
include(":feature:access:ui")
include(":feature:range:api")
include(":feature:range")
include(":feature:range:domain")
include(":feature:range:ui")
include(":feature:home:data")
include(":feature:home:domain")
include(":feature:home:ui")
include(":feature:profile:ui")
include(":feature:vehicle:ui")
