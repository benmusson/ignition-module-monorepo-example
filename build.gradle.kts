plugins {
    base
}

repositories {
    mavenCentral()
    mavenLocal()
    google()
    gradlePluginPortal()
}

val assembleModules by tasks.registering(Copy::class) {
    group = "ignition module"

    val moduleTasks = subprojects.flatMap { subproject ->
        subproject.tasks.named { it == "signModule" || it == "zipModule" }
    }
    val modules = moduleTasks.map {
        it.outputs.files.singleFile
    }

    inputs.files(modules)
    dependsOn(moduleTasks)

    from(modules)
    destinationDir = file("build/modules")
}

val zipModules by tasks.registering(Zip::class) {
    group = "ignition module"
    inputs.files(assembleModules.get().outputs)

    archiveBaseName.set("modules")
    destinationDirectory.set(file("build"))
    from(assembleModules.get().destinationDir)
}

tasks.build {
    dependsOn(zipModules)
}