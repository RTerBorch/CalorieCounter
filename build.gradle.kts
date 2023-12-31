import org.gradle.internal.impldep.org.eclipse.jgit.lib.ObjectChecker.type
import org.gradle.internal.impldep.org.fusesource.jansi.AnsiRenderer.test

plugins {
    java
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
    id("jacoco")
}

group = "com.CalorieCounter"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    // compose
 //   developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok:1.18.26")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.1.0")

    // https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
    implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")
    implementation("com.sun.xml.bind:jaxb-core:4.0.2")
    implementation("com.sun.xml.bind:jaxb-impl:4.0.2")

    //Lombok
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.28")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security
    implementation("org.springframework.boot:spring-boot-starter-security:3.1.3")

    // https://mvnrepository.com/artifact/org.springframework.security/spring-security-test
    testImplementation("org.springframework.security:spring-security-test:6.1.3")

    // https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web
    implementation("org.springframework.boot:spring-boot-starter-web:3.1.3")

    // https://mvnrepository.com/artifact/javax.annotation/javax.annotation-api
    implementation("javax.annotation:javax.annotation-api:1.3.2")

    // https://mvnrepository.com/artifact/com.h2database/h2
    testImplementation("com.h2database:h2:2.2.224")


    // https://mvnrepository.com/artifact/io.rest-assured/rest-assured
    testImplementation("io.rest-assured:rest-assured:5.3.2")



}


tasks.withType<Test> {
    useJUnitPlatform()
    finalizedBy("jacocoTestReport")
}

tasks.named("jacocoTestReport", JacocoReport::class) {
    dependsOn("test")
    reports {
        xml.required.set(true)
    }
}
