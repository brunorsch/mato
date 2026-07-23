import com.github.gradle.node.pnpm.task.PnpmTask

plugins {
    id("com.github.node-gradle.node") version "7.1.0"
}

node {
    version.set("22.19.0")
    download.set(true)
}

tasks.pnpmInstall {
    environment.set(mapOf("CI" to "true"))
}

tasks.register<PnpmTask>("buildFrontend") {
    dependsOn(tasks.pnpmInstall)

    pnpmCommand.set(mutableListOf("build"))
}