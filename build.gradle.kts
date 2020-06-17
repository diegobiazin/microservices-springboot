import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
	repositories {
		mavenCentral()
	}

	dependencies {
		classpath("io.spring.gradle:dependency-management-plugin:1.0.9.RELEASE")
	}
}

plugins {
	id("org.springframework.boot") version "2.3.1.RELEASE" apply false
	id("io.spring.dependency-management") version "1.0.9.RELEASE" apply false
	kotlin("jvm") version "1.3.72" apply false
	kotlin("plugin.spring") version "1.3.72" apply false
	kotlin("plugin.jpa") version "1.3.72" apply false
}

allprojects {
	group = "com.diegobiazin.template-microservices"
	version = "0.0.1-SNAPSHOT"

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
		targetCompatibility = "11"
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<org.springframework.boot.gradle.tasks.bundling.BootJar> {
		enabled = false
	}
	tasks.withType<Jar> {
		enabled = true
	}
}

subprojects {
	repositories {
		mavenCentral()
	}

	apply {
		plugin("io.spring.dependency-management")
	}
}
