plugins {
    java
    id("com.gradleup.shadow") version "8.3.6"
}

group = "br.hexoria"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.21.8-R0.1-SNAPSHOT")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}

tasks {
    jar { archiveClassifier.set("plain") }
    shadowJar { archiveClassifier.set("") }
    build { dependsOn(shadowJar) }
}
