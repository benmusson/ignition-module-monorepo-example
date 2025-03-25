import {
  AbstractUIElementStore,
  ComponentMeta,
  ComponentProps,
  ComponentStoreDelegate,
  JsObject,
  PComponent,
  PropertyTree,
  SizeObject,
  StyleObject,
} from '@inductiveautomation/perspective-client'
import React from 'react'

type ExampleComponentProps = {
  text: string
  style: StyleObject
}

export function ExampleComponent(props: ComponentProps<ExampleComponentProps>) {
  return <div {...props.emit()}>{props.props.text}</div>
}

export class ExampleComponentDelegate extends ComponentStoreDelegate {
  handleEvent(eventName: string, eventObject: JsObject): void {
    console.log(`Received event ${eventName}:`, eventObject)
  }
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
  createDelegate: function (
    component: AbstractUIElementStore
  ): ComponentStoreDelegate {
    return new ExampleComponentDelegate(component)
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
