plugins {
    javaLibrary
    jetbrainsKotlinJvm
}

java {
    sourceCompatibility = Java.javaVersion
    targetCompatibility = Java.javaVersion
}

dependencies {

    implementAll(Dependencies.domainImplementation)
}