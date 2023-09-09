plugins {
    java
    id("org.springframework.boot") version "3.1.3"
    id("io.spring.dependency-management") version "1.1.3"
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.projectlombok:lombok:1.18.22")
    implementation("org.projectlombok:lombok:1.18.22")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    // https://mvnrepository.com/artifact/com.mysql/mysql-connector-j
    implementation("com.mysql:mysql-connector-j:8.1.0")

    // https://mvnrepository.com/artifact/javax.xml.bind/jaxb-api
    implementation("javax.xml.bind:jaxb-api:2.3.1")
    implementation("com.sun.xml.bind:jaxb-core:2.3.0.1")
    implementation("com.sun.xml.bind:jaxb-impl:2.3.3")

    //Lombok
// https://mvnrepository.com/artifact/org.projectlombok/lombok
    compileOnly("org.projectlombok:lombok:1.18.28")


}

tasks.withType<Test> {
    useJUnitPlatform()
}
