import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "2.7.1"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "1.7.0"
    kotlin("plugin.spring") version "1.7.0"
}

group = "me.dungdm93"
version = "1.0-SNAPSHOT"

java.toolchain {
    languageVersion.set(JavaLanguageVersion.of(11))
}

repositories {
    mavenCentral()
    maven {
        name = "spring"
        url = uri("https://repo.spring.io/milestone")
    }
}

extra["springShellVersion"] = "2.1.0-M5"

// https://docs.spring.io/dependency-management-plugin/docs/current/reference/html/
dependencyManagement {
    imports {
        mavenBom("org.springframework.shell:spring-shell-dependencies:${property("springShellVersion")}")
    }
    dependencies {
        dependency("org.apache.hadoop:hadoop-client:3.3.3")
        dependency("org.apache.avro:avro:1.11.0")
        dependency("org.apache.orc:orc-core:1.7.5")
        dependency("org.apache.parquet:parquet-avro:1.12.3")
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.springframework.shell:spring-shell-starter")

    implementation("org.apache.hadoop:hadoop-client")
    implementation("org.apache.avro:avro")
    implementation("org.apache.orc:orc-core")
    implementation("org.apache.parquet:parquet-avro")

    testImplementation(kotlin("test"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
