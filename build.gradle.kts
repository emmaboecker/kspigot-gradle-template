import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.30"
    id("com.github.johnrengelman.shadow") version "6.1.0"
    id("com.github.gmazzo.buildconfig") version "2.0.2"
}

group = "org.example"
version = "1.0.0"

repositories {
    jcenter()
    maven(url = "https://papermc.io/repo/repository/maven-public/")
}

val minecraft_version: String by project

dependencies {
    // PaperMC Dependency
    compileOnly("com.destroystokyo.paper", "paper-api", "$minecraft_version-R0.1-SNAPSHOT") // Only used on compile time because we have a PaperMC Server so we don't need it in the final jar

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
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}
