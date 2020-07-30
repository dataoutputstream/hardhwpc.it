import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';

class GridproductItem extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;" id="layout">
 <vaadin-vertical-layout id="img" style="height: 50%; align-self: center; align-items: center;"></vaadin-vertical-layout>; 
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch;">
  <vaadin-text-field id="name" style="margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); align-self: stretch; flex-grow: 1; flex-shrink: 0;" readonly></vaadin-text-field>
  <iron-icon style="align-self: center; margin-top: var(--lumo-space-xs);" icon="vaadin:euro"></iron-icon>
  <vaadin-text-field id="productprice" style="margin-right: var(--lumo-space-m);" readonly></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-text-area id="description" style="flex-grow: 1; padding: var(--lumo-space-s); align-self: stretch; margin: var(--lumo-space-s);" readonly></vaadin-text-area>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'gridproduct-item';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(GridproductItem.is, GridproductItem);
