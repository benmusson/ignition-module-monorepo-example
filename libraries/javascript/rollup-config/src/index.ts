import * as path from 'node:path'
import typescript from '@rollup/plugin-typescript'
import { default as externalGlobals } from 'rollup-plugin-external-globals'
import terser from '@rollup/plugin-terser'
import commonjs from '@rollup/plugin-commonjs'
import nodeResolve from '@rollup/plugin-node-resolve'

export type PerspectiveConfigOptions = {
  entry: string
  globals?: Record<string, string>
}

export function createPerspectiveConfig(options: PerspectiveConfigOptions) {
  const name = path.parse(options.entry).name

  const globals = {
    react: 'React',
    'react-dom': 'ReactDOM',
    '@inductiveautomation/perspective-client': 'PerspectiveClient',
    '@inductiveautomation/perspective-designer': 'PerspectiveDesigner',
    ...options.globals,
  }

  return [
    {
      input: options.entry,
      output: {
        file: `dist/${name}.js`,
        format: 'cjs',
        exports: 'auto',
        sourcemap: false,
        inlineDynamicImports: true,
      },
      external: Object.keys(globals),
      plugins: [
        typescript(),
        nodeResolve(),
        commonjs(),
        externalGlobals(globals),
        terser(),
      ],
    },
    {
      input: options.entry,
      output: {
        dir: 'dist',
        format: 'es',
        sourcemap: false,
        chunkFileNames: `${name}-[name].js`,
      },
      plugins: [
        typescript(),
        nodeResolve(),
        externalGlobals(globals),
        terser(),
      ],
    },
  ]
}
