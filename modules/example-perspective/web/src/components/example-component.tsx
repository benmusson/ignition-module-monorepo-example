import {
  ComponentMeta,
  ComponentProps,
  PComponent,
  PropertyTree,
  SizeObject,
  StyleObject,
} from '@inductiveautomation/perspective-client'
import React from 'react'

import './example-component.css'

type ExampleComponentProps = {
  text: string
  style: StyleObject
}

export function ExampleComponent(props: ComponentProps<ExampleComponentProps>) {
  return (
    <div {...props.emit()}>
      <button className="cool-button">{props.props.text}</button>
    </div>
  )
}

export const ExampleComponentMeta: ComponentMeta = {
  getComponentType: function (): string {
    return 'example.component'
  },
  getDefaultSize: function (): SizeObject {
    return {
      width: 300,
      height: 300,
    }
  },
  getPropsReducer(tree: PropertyTree): ExampleComponentProps {
    return {
      text: tree.readString('text'),
      style: tree.readStyle('style'),
    } as never
  },
  getViewComponent: function (): PComponent {
    return ExampleComponent as PComponent
  },
}
