import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class PresentationLayerConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig {
                    minSdk = 30
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = false
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }

                compileOptions {
                    sourceCompatibility = JavaVersion.VERSION_11
                    targetCompatibility = JavaVersion.VERSION_11
                }

                buildFeatures {
                    compose = true
                }

                composeOptions {
                    kotlinCompilerExtensionVersion = "1.5.4"
                }
            }

            extensions.configure<KotlinAndroidProjectExtension> {
                compilerOptions {
                    jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11)
                }
            }

            dependencies {
                // Common presentation layer dependencies
                add("implementation", "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
                add("implementation", "androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
                add("implementation", "androidx.lifecycle:lifecycle-viewmodel-compose:2.7.0")
                add("implementation", "androidx.compose.ui:ui:1.5.4")
                add("implementation", "androidx.compose.ui:ui-tooling-preview:1.5.4")
                add("implementation", "androidx.compose.material3:material3:1.1.2")
                add("implementation", "io.insert-koin:koin-androidx-compose:3.5.0")
            }
        }
    }
}