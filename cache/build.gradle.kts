plugins {
    androidApplication
    androidLibrary
    kaptPlugin
    daggerHilt
    navigationSafeArgsKotlin
    kotlinParcelize
}


android {
    compileSdk = Versions.compileSdk

    defaultConfig {
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
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
}


dependencies {

    implementAll(Dependencies.cacheImplementation)
    testImplementAll(TestDependencies.cacheTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.cacheTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
}