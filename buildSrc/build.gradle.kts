plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.12.0-alpha03")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:2.0.21")
}
