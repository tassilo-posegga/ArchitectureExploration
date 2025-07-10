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
include(":feature:climatisation:data")
include(":feature:climatisation:domain")
include(":feature:climatisation:presentation")
include(":feature:climatisation:di")
include(":feature:range:api")
include(":feature:range")
include(":feature:range:data")
include(":feature:range:domain")
include(":feature:range:presentation")
include(":feature:range:di")
include(":feature:home:data")
include(":feature:home:domain")
include(":feature:home:presentation")
include(":feature:home:di")
include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:profile:presentation")
include(":feature:profile:di")
include(":feature:vehicle:data")
include(":feature:vehicle:domain")
include(":feature:vehicle:presentation")
include(":feature:vehicle:di")
