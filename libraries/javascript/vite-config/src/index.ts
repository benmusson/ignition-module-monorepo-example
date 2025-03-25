import { defineConfig } from 'vite'
import { default as externalGlobals } from 'rollup-plugin-external-globals'
import * as path from 'node:path'

export type PerspectiveConfigOptions = {
  entry: string
  globals?: Record<string, string>
}

export function createPerspectiveConfig(options: PerspectiveConfigOptions) {
  const name = path.parse(options.entry).name

  return defineConfig((configEnv) => ({
    build: {
      outDir: './dist',
      lib: {
        entry: options.entry,
        name: name,
        formats: ['es'],
      },
      rollupOptions: {
        output: {
          entryFileNames: `${name}.js`,
        },
        plugins: [
          externalGlobals({
            react: 'React',
            'react-dom': 'ReactDOM',
            '@inductiveautomation/perspective-client': 'PerspectiveClient',
            '@inductiveautomation/perspective-designer': 'PerspectiveDesigner',
            ...options?.globals,
          }),
        ],
      },
    },
    test: {
      passWithNoTests: true,
      fileParallelism: configEnv.mode !== 'benchmark',
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
}
