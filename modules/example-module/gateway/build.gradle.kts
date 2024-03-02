plugins {
    id("example.ignition-module-library-conventions")
}

dependencies {
    compileOnly(libs.bundles.gateway)
    compileOnly(projects.modules.exampleModule.common)
}