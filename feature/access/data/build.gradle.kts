plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "eu.aggesop.architectureexploration.feature.access.data"
    compileSdk = 36

    defaultConfig {
        minSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    implementation(project(":feature:access:domain"))
    implementation(project(":core:network"))
    implementation(project(":core:data"))

    implementation(libs.kotlinx.coroutines.core)
}
