import typescript from '@rollup/plugin-typescript'
import { default as externalGlobals } from 'rollup-plugin-external-globals'
import terser from '@rollup/plugin-terser'
import commonjs from '@rollup/plugin-commonjs'

export default [
  {
    input: 'src/ExamplePerspective.cjs',
    output: {
      file: 'dist/ExamplePerspective.js',
      format: 'cjs',
      exports: 'auto',
      sourcemap: false,
      inlineDynamicImports: true,
    },
    external: [
      'react',
      'react-dom',
      '@inductiveautomation/perspective-client',
      '@inductiveautomation/perspective-designer',
    ],
    plugins: [
      typescript(),
      commonjs(),
      externalGlobals({
        react: 'React',
        'react-dom': 'ReactDOM',
        '@inductiveautomation/perspective-client': 'PerspectiveClient',
        '@inductiveautomation/perspective-designer': 'PerspectiveDesigner',
      }),
      terser(),
    ],
  },
  {
    input: 'src/ExamplePerspective.cjs',
    output: {
      dir: 'dist',
      format: 'es',
      sourcemap: false,
      chunkFileNames: `ExamplePerspective-[name].js`,
    },
    plugins: [
      typescript(),
      externalGlobals({
        react: 'React',
        'react-dom': 'ReactDOM',
        '@inductiveautomation/perspective-client': 'PerspectiveClient',
        '@inductiveautomation/perspective-designer': 'PerspectiveDesigner',
      }),
      terser(),
    ],
  },
]
