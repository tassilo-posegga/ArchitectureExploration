plugins {
    kotlin("jvm")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
    }
}

dependencies {
    // Domain layer should not depend on other layers directly
    // It can depend on other domain modules if needed
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.3")
}