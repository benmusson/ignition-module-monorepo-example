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

        private val BROWSER_RESOURCES =
            mutableSetOf(
                BrowserResource(
                    "ExamplePerspective-client",
                    "/res/${Meta.SHORT_MODULE_ID}/index.js",
                    BrowserResource.ResourceType.JS,
                )
            )

        val DESCRIPTOR =
            ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory("Example Perspective Module")
            .setId(COMPONENT_ID)
            .setModuleId(Meta.MODULE_ID)
            .setSchema(SCHEMA)
            .setName("Example Component")
            .addPaletteEntry("base", "Example Component", "An example component.", null, null)
            .setDefaultMetaName("Example Component")
            .setResources(BROWSER_RESOURCES)
            .build()
    }
}
