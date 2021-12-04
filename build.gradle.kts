import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.0"
}

group = "org.example"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
}

dependencies {
    // PaperMC Dependency
    compileOnly("io.papermc.paper:paper-api:1.18-R0.1-SNAPSHOT") // Only used on compile time because we have a PaperMC Server so we don't need it in the final jar

    // KSpigot dependency
    implementation("net.axay:kspigot:1.17.4")

    // You can add Dependencies here
    // For Example:
    // implementation("io.ktor", "ktor-client", "1.4.0") // This would be shaded into the final jar
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "17"
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}
