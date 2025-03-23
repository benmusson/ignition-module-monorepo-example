package com.example.ignition.example.perspective.components

import Meta
import com.inductiveautomation.ignition.common.jsonschema.JsonSchema
import com.inductiveautomation.perspective.common.api.BrowserResource
import com.inductiveautomation.perspective.common.api.ComponentDescriptor
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl

class ExampleComponent {
    companion object {
        const val COMPONENT_ID: String = "example.component"
        private val SCHEMA: JsonSchema =
            JsonSchema.parse(
                Meta::class
                    .java
                    .getResourceAsStream("/schemas/components/$COMPONENT_ID/props.json")
            )

        private val BROWSER_RESOURCES_CLIENT =
            mutableSetOf(
                BrowserResource(
                    "ExamplePerspective-client",
                    "/res/example-module-perspective/ExamplePerspective-client.js",
                    BrowserResource.ResourceType.JS,
                )
            )

        private val BROWSER_RESOURCES_DESIGNER =
            mutableSetOf(
                BrowserResource(
                    "ExamplePerspective-designer",
                    "/res/example-module-perspective/ExamplePerspective-designer.js",
                    BrowserResource.ResourceType.JS,
                )
            )

        private val descriptorBuilder: ComponentDescriptorImpl.ComponentBuilder =
            ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory("Example Perspective Module")
            .setId(COMPONENT_ID)
            .setModuleId(Meta.MODULE_ID)
            .setSchema(SCHEMA)
            .setName("Example Component")
            .addPaletteEntry("base", "Example Component", "An example component", null, null)
            .setDefaultMetaName("Example Component")

        val DESCRIPTOR_CLIENT = descriptorBuilder
            .setResources(BROWSER_RESOURCES_CLIENT)
            .build()

        val DESCRIPTOR_DESIGNER = descriptorBuilder
            .setResources(BROWSER_RESOURCES_DESIGNER)
            .build()
    }
}
