import java.text.SimpleDateFormat
import java.util.*

plugins {
    id("example.kotlin-library-conventions")
    id("io.ia.sdk.modl")
}

fun buildTime(): String { return SimpleDateFormat("yyyyMMddHH").format(Date()) }

allprojects {
    group = "com.example.ignition"
}

ignitionModule {
    skipModlSigning.set(true)
}

tasks.deployModl {
    hostGateway = "http://localhost:8088"
}