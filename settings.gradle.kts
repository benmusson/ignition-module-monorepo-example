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

    ":modules:example-module-2:common",
    ":modules:example-module-2:gateway",

    ":modules:example-perspective:common",
    ":modules:example-perspective:designer",
    ":modules:example-perspective:gateway",
    ":modules:example-perspective:web",
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
