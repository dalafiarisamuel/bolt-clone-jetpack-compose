plugins {
    androidComLibrary
    androidLibrary
    kaptPlugin
    daggerHilt
    kotlinParcelize
}


android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        testInstrumentationRunner = Application.testInstrumentationRunner
    }

    compileOptions {
        targetCompatibility = Java.javaVersion
        sourceCompatibility = Java.javaVersion
    }

    kotlinOptions {
        jvmTarget = Java.javaVersion.toString()
    }
}


dependencies {

    implementation(project(BuildModule.DATA))
    implementAll(Dependencies.cacheImplementation)
    testImplementAll(TestDependencies.cacheTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.cacheTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)

    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.0") {
        exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-debug")
    }
}