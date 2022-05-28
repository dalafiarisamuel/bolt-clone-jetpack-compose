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
    implementation(project(BuildModule.DOMAIN))
    implementation(project(BuildModule.CACHE))
    implementation(project(BuildModule.DATA))
    implementAll(Dependencies.coreImplementations)
    kaptImplementAll(AnnotationProcessors.AnnotationProcessorsImplementation)

}