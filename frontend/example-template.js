import { html, PolymerElement } from '@polymer/polymer';
 
export class ExampleTemplate extends PolymerElement {
   static get is() {
     return 'example-template'
   }
   
   static get template() {
	 return html`<span>[[message]]</span>`;
   }
}

customElements.define(ExampleTemplate.is, ExampleTemplate);