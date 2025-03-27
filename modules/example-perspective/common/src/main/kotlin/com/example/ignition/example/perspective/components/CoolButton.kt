package com.example.ignition.example.perspective.components

import Meta
import com.inductiveautomation.ignition.common.jsonschema.JsonSchema
import com.inductiveautomation.perspective.common.api.BrowserResource
import com.inductiveautomation.perspective.common.api.ComponentDescriptor
import com.inductiveautomation.perspective.common.api.ComponentDescriptorImpl

class CoolButton {
    companion object {
        const val COMPONENT_ID: String = "example.cool-button"
        private val SCHEMA: JsonSchema =
            JsonSchema.parse(
                Meta::class
                    .java
                    .getResourceAsStream("/schemas/components/$COMPONENT_ID/props.json")
            )

        val DESCRIPTOR: ComponentDescriptor =
            ComponentDescriptorImpl.ComponentBuilder.newBuilder()
            .setPaletteCategory("Examples")
            .setId(COMPONENT_ID)
            .setModuleId(Meta.MODULE_ID)
            .setSchema(SCHEMA)
            .setName("Cool Button")
            .addPaletteEntry("base", "Cool Button", "A really cool button.", null, null)
            .setDefaultMetaName("Cool Button")
            .setResources(Meta.BROWSER_RESOURCES)
            .build()
    }
}
