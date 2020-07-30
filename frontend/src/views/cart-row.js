import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class CartRow extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout theme="spacing">
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
  <vaadin-item id="name" style="align-self: stretch; flex-grow: 1;"></vaadin-item>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
  <vaadin-item id="price" style="align-self: stretch; flex-grow: 1;"></vaadin-item>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
  <vaadin-item id="quanitity" style="align-self: stretch; flex-grow: 1;"></vaadin-item>
 </vaadin-vertical-layout>
 <vaadin-vertical-layout theme="spacing" style="flex-grow: 1;">
  <vaadin-item id="total" style="align-self: stretch; flex-grow: 0;"></vaadin-item>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'cart-row';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CartRow.is, CartRow);
