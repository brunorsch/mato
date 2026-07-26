plugins {
	id("org.springframework.boot") version "4.1.0"
	id("io.spring.dependency-management") version "1.1.7"
}

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(26)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-mail")
	//implementation("org.springframework.boot:spring-boot-starter-security")
	//implementation("org.springframework.boot:spring-boot-starter-security-oauth2-resource-server")
	//implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("org.springframework.boot:spring-boot-starter-webmvc")
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	//implementation("com.okta.spring:okta-spring-boot-starter:3.1.0")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")
	//testImplementation("org.springframework.boot:spring-boot-starter-flyway-test")
	//testImplementation("org.springframework.boot:spring-boot-starter-mail-test")
	//testImplementation("org.springframework.boot:spring-boot-starter-security-oauth2-resource-server-test")
	//testImplementation("org.springframework.boot:spring-boot-starter-security-test")
	//testImplementation("org.springframework.boot:spring-boot-starter-validation-test")
	testImplementation("org.springframework.boot:spring-boot-starter-webmvc-test")
	testCompileOnly("org.projectlombok:lombok")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	testAnnotationProcessor("org.projectlombok:lombok")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.register<Copy>("copyFrontend") {
	dependsOn(":web:buildFrontend")

	from("../web/dist")
	into("src/main/resources/static")
}

tasks.named("processResources") {
	dependsOn("copyFrontend")
}