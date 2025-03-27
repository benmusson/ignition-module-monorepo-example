package com.example.ignition.example.perspective

import com.example.ignition.example.perspective.components.CoolButton
import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.designer.model.AbstractDesignerModuleHook
import com.inductiveautomation.ignition.designer.model.DesignerContext
import com.inductiveautomation.perspective.designer.DesignerComponentRegistry
import com.inductiveautomation.perspective.designer.api.ComponentDesignDelegateRegistry
import com.inductiveautomation.perspective.designer.api.PerspectiveDesignerInterface
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Suppress("unused")
class DesignerHook : AbstractDesignerModuleHook() {

    private val logger: Logger = LoggerFactory.getLogger("ExampleModulePerspective")
    private lateinit var context: DesignerContext
    private lateinit var componentRegistry: DesignerComponentRegistry
    private lateinit var delegateRegistry: ComponentDesignDelegateRegistry

    override fun startup(context: DesignerContext, activationState: LicenseState) {
        logger.debug("Example module '${Meta.SHORT_MODULE_ID}' starting...")
        this.context = context

        val pdi: PerspectiveDesignerInterface = PerspectiveDesignerInterface.get(context)

        componentRegistry = pdi.designerComponentRegistry
        delegateRegistry = pdi.componentDesignDelegateRegistry

        componentRegistry.registerComponent(CoolButton.DESCRIPTOR)
    }

    override fun shutdown() {
        logger.debug("Example module '${Meta.SHORT_MODULE_ID}' stopping...")

        logger.debug("Removing components...")
        componentRegistry.removeComponent(CoolButton.COMPONENT_ID)
    }
}