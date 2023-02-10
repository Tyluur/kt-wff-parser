import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    kotlin("plugin.serialization") version "1.7.20"
}

group = "com.tyluur"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.toVersion('8')
java.targetCompatibility = JavaVersion.toVersion('8')

repositories {
    mavenCentral()
    mavenLocal()
    jcenter()
    maven(url = "https://repo.maven.apache.org/maven2")
    maven(url = "https://dl.bintray.com/michaelbull/maven")
}

dependencies {
    // Java
    implementation(kotlin("stdlib-jdk8"))

    //Logging
    implementation(group = "org.slf4j", name = "slf4j-api", version = "2.0.5")
    implementation(group = "ch.qos.logback", name = "logback-classic", version = "1.4.5")
    implementation(
        group = "com.michael-bull.kotlin-inline-logger", name = "kotlin-inline-logger-jvm", version = "1.0.2"
    )
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}