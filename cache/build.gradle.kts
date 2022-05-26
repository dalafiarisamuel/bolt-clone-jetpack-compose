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
    }
}


dependencies {

    implementAll(Dependencies.cacheImplementation)
    testImplementAll(TestDependencies.cacheTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.cacheTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
}