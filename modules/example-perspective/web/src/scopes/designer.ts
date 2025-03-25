import { ComponentRegistry } from '@inductiveautomation/perspective-client'

import { ExampleComponent, ExampleComponentMeta } from '../components'
import { sharedUtility } from '../util'

export { ExampleComponent }
ComponentRegistry.register(ExampleComponentMeta)

console.log('This code will only run in the designer.')
sharedUtility()
