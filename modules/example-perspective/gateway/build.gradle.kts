plugins {
    id("example.ignition-module-library-conventions")
}

dependencies {
    compileOnly(libs.bundles.gateway)
    compileOnly(libs.bundles.perspectiveGateway)
    compileOnly(projects.modules.examplePerspective.common)
    modlImplementation(projects.modules.examplePerspective.web)
}