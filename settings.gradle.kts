plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}


rootProject.name = "ghost-viewer"

include("ghost-viewer-cli")
include("ghost-viewer-cli-command")
