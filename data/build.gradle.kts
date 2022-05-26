plugins {
    javaLibrary
    jetbrainsKotlinJvm
}

java {
    sourceCompatibility = Java.javaVersion
    targetCompatibility = Java.javaVersion
}

kotlin {
    val compilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = Java.javaVersion.toString()
        kotlinOptions.freeCompilerArgs += compilerArgs
    }
}

dependencies {

    implementAll(Dependencies.dataImplementation)
    implementation(project(BuildModule.DOMAIN))
}