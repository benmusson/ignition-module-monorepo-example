plugins {
    id("example.ignition-module-conventions")
}

allprojects {
    version = "0.1.0"
}

ignitionModule {
    name.set("Example Perspective Module")
    moduleDescription.set("An example module that adds resource to Perspective.")
    id.set("com.example.ignition.example-perspective")
    fileName.set("ExampleModulePerspective.modl")
    moduleVersion.set("$version")
    freeModule.set(true)
    requiredIgnitionVersion.set(libs.versions.ignition)

    moduleDependencies.set(
        mapOf(
            "com.inductiveautomation.perspective" to "GD",
        ),
    )

    projectScopes.putAll(
        mapOf(
            ":modules:example-perspective:common" to "GD",
            ":modules:example-perspective:designer" to "D",
            ":modules:example-perspective:gateway" to "G",
            ":modules:example-perspective:web" to "G",
        ),
    )

    hooks.putAll(
        mapOf(
            "com.example.ignition.example.perspective.DesignerHook" to "D",
            "com.example.ignition.example.perspective.GatewayHook" to "G"
        ),
    )
}
