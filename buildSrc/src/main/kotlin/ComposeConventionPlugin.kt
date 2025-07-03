import com.android.build.gradle.BaseExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.findByType

class ComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.plugin.compose")
            }

            // Configure compose build feature after evaluation to ensure android extension is available
            afterEvaluate {
                extensions.findByType<BaseExtension>()?.apply {
                    buildFeatures.compose = true
                }
            }
        }
    }
}
