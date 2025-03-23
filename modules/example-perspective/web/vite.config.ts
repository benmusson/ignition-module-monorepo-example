import { defineConfig } from 'vite'
import { globSync } from 'glob'
import { default as externalGlobals } from 'rollup-plugin-external-globals'

const packageName = 'ExamplePerspective'
const entryFiles = globSync('src/entry-points/*.ts')
const globals = {
    react: 'React',
    'react-dom': 'ReactDOM',
    '@inductiveautomation/perspective-client': 'PerspectiveClient',
}

export default defineConfig(({ mode }) => ({
    build: {
        outDir: './dist',
        lib: {
            entry: entryFiles,
            name: packageName,
            formats: ['es'],
        },
        rollupOptions: {
            output: {
                entryFileNames: `${packageName}-[name].js`,
                chunkFileNames: `${packageName}-[name].[hash].js`,
            },
            plugins: [
                externalGlobals(globals),
            ],
        },
    },
    test: {
        passWithNoTests: true,
        fileParallelism: mode !== 'benchmark',
        globals: true,
        environment: 'node',
        include: [
            'src/**/*.{test,spec}.{js,mjs,cjs,ts,mts,cts,jsx,tsx}',
            '__tests__/**/*.{test,spec}.{js,mjs,cjs,ts,mts,cts,jsx,tsx}',
        ],
        reporters: ['default'],
        coverage: {
            reportsDirectory: '../coverage/js/chart-js',
            provider: 'v8',
        },
    },
}))
