plugins {
    id("example.ignition-module-library-conventions")
}

dependencies {
    compileOnly(libs.bundles.gateway)
    compileOnly(libs.bundles.perspectiveDesigner)
    compileOnly(projects.modules.examplePerspective.common)
}