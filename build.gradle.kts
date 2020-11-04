import org.jetbrains.kotlin.cli.jvm.compiler.findMainClass

plugins {
    application
    kotlin("jvm") version "1.4.10"
}

group = "software.steinhauer.interviews.ee"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib"))

    testImplementation(platform("org.junit:junit-bom:5.7.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.strikt:strikt-core:0.28.0")
    testImplementation("io.mockk:mockk:1.10.2")
}

application {
    mainClassName = "software.steinhauer.interviews.ee.ApplicationKt"
}

tasks.test {
    useJUnitPlatform()
}