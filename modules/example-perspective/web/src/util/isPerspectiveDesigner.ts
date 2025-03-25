declare global {
  interface Window {
    _perspective_designer?: boolean
  }
}

export default function isPerspectiveDesigner() {
  return window._perspective_designer || false
}
