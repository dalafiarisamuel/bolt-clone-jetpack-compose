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

    compileOptions {
        targetCompatibility = Java.javaVersion
        sourceCompatibility = Java.javaVersion
    }

    kotlinOptions {
        jvmTarget = Java.javaVersion.toString()
    }
}

dependencies {

    implementation(project(BuildModule.REMOTE))
    implementAll(Dependencies.remoteImplementation)
    testImplementAll(TestDependencies.remoteTestImplementation)
    testAndroidImplementAll(AndroidTestDependencies.remoteTestImplementation)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
    kaptAndroidTestImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)
}