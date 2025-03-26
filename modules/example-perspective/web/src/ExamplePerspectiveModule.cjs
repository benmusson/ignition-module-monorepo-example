import { isPerspectiveDesigner } from './util'

if (isPerspectiveDesigner()) {
  import('./scopes/designer.ts')
} else {
  import('./scopes/client.ts')
}
