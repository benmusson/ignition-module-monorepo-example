plugins {
    id("example.ignition-module-conventions")
}

allprojects {
    version = "0.1.0"
}

ignitionModule {
    name.set("Example Module")
    moduleDescription.set("An example module.")
    id.set("com.example.ignition.example")
    fileName.set("ExampleModule.modl")
    moduleVersion.set("$version")
    freeModule.set(true)
    requiredIgnitionVersion.set(libs.versions.ignition)

    projectScopes.putAll(
        mapOf(
            ":modules:example-module:common" to "GD",
            ":modules:example-module:gateway" to "G",
        ),
    )

    hooks.putAll(
        mapOf(
            "com.example.ignition.example.GatewayHook" to "G"
        ),
    )
}
