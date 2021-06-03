import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.5.10"
    id("com.github.johnrengelman.shadow") version "7.0.0"
    id("com.github.gmazzo.buildconfig") version "3.0.0"
}

group = "org.example"
version = "1.0.0"

repositories {
    jcenter()
    mavenCentral()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
    maven("https://repo.codemc.io/repository/maven-snapshots/")
}

val minecraft_version: String by project

dependencies {
    // PaperMC Dependency
    compileOnly("com.destroystokyo.paper", "paper-api", "$minecraft_version-R0.1-SNAPSHOT") // Only used on compile time because we have a PaperMC Server so we don't need it in the final jar

    // KSpigot dependency
    implementation("net.axay", "kspigot", "1.16.29")

    // You can add Dependencies here
    // For Example:
    // implementation("io.ktor", "ktor-client", "1.4.0") // This would be shaded into the final jar
}

tasks {
    jar {
        // Disabled, because we use the shadowJar task for building our jar
        enabled = false
    }
    build {
        dependsOn(shadowJar)
    }
    // Relocating KSpigot to prevent conflicts with multiple Plugins using KSpigot
    shadowJar {
        relocate("net.axay.kspigot", "${project.group}.${project.name.toLowerCase()}.shadow.net.axay.kspigot")
    }
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}
