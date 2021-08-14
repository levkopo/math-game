plugins {
    kotlin("jvm") version "1.5.10"
}

group = "ru.levkopo"
version = "1.0"

repositories {
    mavenCentral()
}

tasks.jar {
    manifest.attributes["Main-Class"] = "MainKt"
    from(configurations.compileClasspath.get().map { if(it.isDirectory) it else zipTree(it)})
}

dependencies {
    implementation(kotlin("stdlib"))
}