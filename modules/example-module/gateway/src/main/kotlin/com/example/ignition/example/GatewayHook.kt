package com.example.ignition.example

import com.inductiveautomation.ignition.common.licensing.LicenseState
import com.inductiveautomation.ignition.gateway.model.AbstractGatewayModuleHook
import com.inductiveautomation.ignition.gateway.model.GatewayContext
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Suppress("unused")
class GatewayHook : AbstractGatewayModuleHook() {

    private val logger: Logger = LoggerFactory.getLogger("ExampleModule")
    private lateinit var context: GatewayContext

    override fun setup(context: GatewayContext) {
        this.context = context
    }

    override fun startup(activationState: LicenseState) {
        logger.info("Example module '${Meta.SHORT_MODULE_ID}' starting...")
    }

    override fun shutdown() {
        logger.info("Example module '${Meta.SHORT_MODULE_ID}' stopping...")
    }

    override fun isFreeModule(): Boolean {
        return true
    }

    override fun isMakerEditionCompatible(): Boolean {
        return true
    }
}