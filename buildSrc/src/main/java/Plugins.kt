import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

val PluginDependenciesSpec.androidApplication: PluginDependencySpec
    get() = id("com.android.application")

val PluginDependenciesSpec.androidComLibrary: PluginDependencySpec
    get() = id("com.android.library")

val PluginDependenciesSpec.androidLibrary: PluginDependencySpec
    get() = kotlin("android")

val PluginDependenciesSpec.kaptPlugin: PluginDependencySpec
    get() = kotlin("kapt")

val PluginDependenciesSpec.kotlinParcelize: PluginDependencySpec
    get() = id("kotlin-parcelize")

val PluginDependenciesSpec.navigationSafeArgsKotlin: PluginDependencySpec
    get() = id("androidx.navigation.safeargs.kotlin")

val PluginDependenciesSpec.daggerHilt: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

val PluginDependenciesSpec.javaLibrary: PluginDependencySpec
    get() = id("java-library")

val PluginDependenciesSpec.jetbrainsKotlinJvm: PluginDependencySpec
    get() = id("org.jetbrains.kotlin.jvm")