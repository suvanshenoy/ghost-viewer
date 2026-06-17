plugins {
    application
    alias(libs.plugins.graalvm.buildtools.native)
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation(libs.guava)
    implementation(libs.picocli)
    annotationProcessor(libs.picocli.codegen)
    implementation(project(":ghost-viewer-cli-command"))
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(25)
    }
}

application {
    mainClass = "com.github.ghostviewer.cli.AppCli"
}

graalvmNative {
    binaries {
        named("main") {
            imageName.set("ghost-viewer")
            mainClass.set("com.github.ghostviewer.cli.AppCli")
            quickBuild.set(true)

            resources.autodetect()
            if(System.getenv("GRAALVM_HOME") == null) {
                toolchainDetection.set(true)
                javaLauncher.set(javaToolchains.launcherFor {
                    languageVersion.set(JavaLanguageVersion.of(25))
                })
            } else {
                    toolchainDetection.set(false)
            }
        }
    }

    metadataRepository {
        enabled.set(true)
    }

    agent {
        enabled.set(true)
        metadataCopy {
            outputDirectories.add("src/main/resources/META-INF/native-image")
            mergeWithExisting.set(true)
        }
    }
}
