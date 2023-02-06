plugins {
    `java-library`
}

repositories {
    mavenLocal()
    maven {
        url = uri("https://repo.maven.apache.org/maven2/")
    }
}

dependencies {
    api("commons-io:commons-io:2.11.0")
}

group = "ru.levelp.at"
version = "1.0-SNAPSHOT"
description = "levelup-automation-basic-win-2023-jan"
java.sourceCompatibility = JavaVersion.VERSION_11
java.targetCompatibility = JavaVersion.VERSION_11

tasks.withType<JavaCompile>() {
    options.encoding = "UTF-8"
}

tasks.withType<Javadoc>() {
    options.encoding = "UTF-8"
}
