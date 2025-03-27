import { ComponentRegistry } from '@inductiveautomation/perspective-client'

import { CoolButton, ExampleComponentMeta } from '../components'
import { sharedUtility } from '../util'

export { CoolButton }
ComponentRegistry.register(ExampleComponentMeta)

console.log('This code will only run in the client.')
sharedUtility()
