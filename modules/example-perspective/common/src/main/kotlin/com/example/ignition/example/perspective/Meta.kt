import com.inductiveautomation.perspective.common.api.BrowserResource

object Meta {
    const val MODULE_ID = "com.example.ignition.example-perspective"
    const val SHORT_MODULE_ID = "example-module-perspective"

    val BROWSER_RESOURCES =
        mutableSetOf(
            BrowserResource(
                "ExamplePerspectiveModule",
                "/res/${SHORT_MODULE_ID}/ExamplePerspectiveModule.js",
                BrowserResource.ResourceType.JS,
            ),
            BrowserResource(
                "ExamplePerspectiveModuleCSS",
                "/res/${SHORT_MODULE_ID}/ExamplePerspectiveModule.css",
                BrowserResource.ResourceType.CSS,
            )
        )
}