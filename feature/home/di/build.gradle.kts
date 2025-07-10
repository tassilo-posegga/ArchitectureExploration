plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "eu.aggesop.architectureexploration.feature.home.di"
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
    implementation(project(":feature:home:domain"))
    implementation(project(":feature:home:presentation"))
    implementation(project(":feature:home:api"))
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}