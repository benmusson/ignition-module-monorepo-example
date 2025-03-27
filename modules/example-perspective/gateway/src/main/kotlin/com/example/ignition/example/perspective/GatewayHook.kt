package com.example.ignition.example.perspective

import com.example.ignition.example.perspective.components.CoolButton
import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook
import com.inductiveautomation.ignition.gateway.model.GatewayContext
import com.inductiveautomation.perspective.common.api.ComponentRegistry
import com.inductiveautomation.perspective.gateway.api.ComponentModelDelegateRegistry
import com.inductiveautomation.perspective.gateway.api.PerspectiveContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*


@Suppress("unused")
class GatewayHook : AbstractGatewayModuleHook() {

    private val logger: Logger = LoggerFactory.getLogger("ExampleModulePerspective")
    private lateinit var context: GatewayContext
    private lateinit var perspectiveContext: PerspectiveContext
    private lateinit var componentRegistry: ComponentRegistry
    private lateinit var modelDelegateRegistry: ComponentModelDelegateRegistry

    override fun setup(context: GatewayContext) {
        this.context = context
    }

    override fun startup(activationState: LicenseState) {
        logger.debug("Example module '${Meta.SHORT_MODULE_ID}' starting...")

        perspectiveContext = PerspectiveContext.get(this.context)
        componentRegistry = perspectiveContext.componentRegistry
        modelDelegateRegistry = perspectiveContext.componentModelDelegateRegistry

        logger.debug("Registering components...")
        componentRegistry.registerComponent(CoolButton.DESCRIPTOR)
    }

    override fun shutdown() {
        logger.debug("Example module '${Meta.SHORT_MODULE_ID}' stopping...")

        logger.debug("Removing components...")
        componentRegistry.removeComponent(CoolButton.COMPONENT_ID)
    }

    override fun getMountedResourceFolder(): Optional<String> {
        return Optional.of("static")
    }

    override fun getMountPathAlias(): Optional<String> {
        return Optional.of(Meta.SHORT_MODULE_ID)
    }

    override fun isFreeModule(): Boolean {
        return true
    }

    override fun isMakerEditionCompatible(): Boolean {
        return true
    }
}