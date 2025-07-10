plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "eu.aggesop.architectureexploration.feature.climatisation.di"
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
    implementation(project(":feature:climatisation:domain"))
    implementation(project(":feature:climatisation:presentation"))
    implementation(project(":feature:climatisation:api"))
    implementation(libs.koin.android)
    implementation(libs.koin.androidx.compose)
}
