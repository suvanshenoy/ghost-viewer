plugins {
    application
    alias(libs.plugins.test.logger)
}

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation(libs.guava)
    implementation(libs.picocli)
}


tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
        events("failed","passed","skipped","standardError","standardOut","started")
    }

    testlogger {
        showExceptions = true
        showStackTraces = true
        showFullStackTraces = false
        showCauses = true
        slowThreshold = 2000
        showSummary = true
        showSimpleNames = false
        showPassed = true
        showSkipped = true
        showFailed = true
        showOnlySlow = false
        showStandardStreams = false
        showPassedStandardStreams = true
        showSkippedStandardStreams = true
        showFailedStandardStreams = true
    }

}
