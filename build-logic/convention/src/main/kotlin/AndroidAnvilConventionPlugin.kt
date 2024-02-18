import com.google.samples.apps.nowinandroid.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidAnvilConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.squareup.anvil:2.4.8-1-8")
                // ksp must go last to avoid build warnings.
                // See: https://stackoverflow.com/questions/70550883/warning-the-following-options-were-not-recognized-by-any-processor-dagger-f
                apply("com.google.devtools.ksp")
            }

//            extensions.configure<com.squareup.anvil.plugin.AnvilExtension>{
//                this.generateDaggerFactories.set(true)
//            }
            dependencies {
                "implementation"(libs.findLibrary("dagger").get())
                "ksp"(libs.findLibrary("dagger.compiler").get())
            }
        }
    }
}
