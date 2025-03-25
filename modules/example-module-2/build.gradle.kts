plugins {
    id("example.ignition-module-conventions")
}

allprojects {
    version = "0.1.0"
}

ignitionModule {
    name.set("Example Module 2")
    moduleDescription.set("Another example module.")
    id.set("com.example.ignition.example2")
    fileName.set("ExampleModule2.modl")
    moduleVersion.set("$version")
    freeModule.set(true)
    requiredIgnitionVersion.set(libs.versions.ignition)

    projectScopes.putAll(
        mapOf(
            ":modules:example-module-2:common" to "GD",
            ":modules:example-module-2:gateway" to "G",
        ),
    )

    hooks.putAll(
        mapOf(
            "com.example.ignition.example2.GatewayHook" to "G"
        ),
    )
}
