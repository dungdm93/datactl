import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    java
    kotlin("jvm") version "1.7.0"
}

group = "me.dungdm93"
version = "1.0-SNAPSHOT"

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
}

application {
    applicationName = "datactl"
    mainClass.set("me.dungdm93.datactl.Main")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
