import * as path from 'node:path'
import typescript from '@rollup/plugin-typescript'
import { default as externalGlobals } from 'rollup-plugin-external-globals'
import terser from '@rollup/plugin-terser'
import commonjs from '@rollup/plugin-commonjs'
import nodeResolve from '@rollup/plugin-node-resolve'
import postcss from 'rollup-plugin-postcss'

export type PerspectiveConfigOptions = {
  entry: string
  globals?: Record<string, string>
}

export function createPerspectiveOutputs(options: PerspectiveConfigOptions) {
  const name = path.parse(options.entry).name

  const globals = {
    react: 'React',
    'react-dom': 'ReactDOM',
    '@inductiveautomation/perspective-client': 'PerspectiveClient',
    '@inductiveautomation/perspective-designer': 'PerspectiveDesigner',
    ...options.globals,
  }

  const plugins = [
    postcss({
      include: '**/*.css', // Merge all CSS files together
      extract: `${name}.css`,
    }),
    typescript(),
    nodeResolve(),
    commonjs(),
    externalGlobals(globals),
    terser(),
  ]

  return [
    {
      input: options.entry,
      output: {
        file: `dist/${name}.js`, // Main entry point is built as CJS format and used as a BrowserResource
        format: 'cjs',
        exports: 'auto',
        sourcemap: false,
        inlineDynamicImports: true,
      },
      external: Object.keys(globals),
      plugins,
    },
    {
      input: options.entry,
      output: {
        dir: 'dist', // All other files are built as ES Modules
        format: 'es',
        sourcemap: false,
        chunkFileNames: `${name}-[name].js`,
      },
      plugins,
    },
  ]
}
