plugins {
    id("java-library")
    id("org.jetbrains.kotlin.jvm")
}

java {
    sourceCompatibility = Java.javaVersion
    targetCompatibility = Java.javaVersion
}

dependencies {

    implementAll(Dependencies.domainImplementation)
}