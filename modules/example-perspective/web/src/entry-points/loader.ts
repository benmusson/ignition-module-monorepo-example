function loadModule(path: string) {
    const module = document.createElement('script')
    module.src = path
    module.type = 'module'
    document.head.appendChild(module)
}

// @ts-ignore
if (window._perspective_designer) {
    console.log(window)
    loadModule('/res/example-module-perspective/ExamplePerspective-designer.js')
} else {
    loadModule('/res/example-module-perspective/ExamplePerspective-client.js')
}