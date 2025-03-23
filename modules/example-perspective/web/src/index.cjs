if (window._perspective_designer) {
    import('./designer.ts')
} else {
    import('./client.ts')
}