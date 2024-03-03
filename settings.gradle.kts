rootProject.name = "ignition-module-monorepo-example"

pluginManagement {
    repositories {
        mavenCentral()
        gradlePluginPortal()
    }
}

include(
    ":",

    ":modules:example-module:common",
    ":modules:example-module:gateway",

    ":modules:example-module2:common",
    ":modules:example-module2:gateway"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
