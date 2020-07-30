import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-icons';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class ProductDialog extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
  <vaadin-vertical-layout theme="spacing" style="align-items: stretch; width: 50%;">
   <div style="margin-top: 20%; margin-right: 10%; margin-left: 10%; height: 50%; width: 90%;">
    <vaadin-vertical-layout id="img" style="height: 100%; align-items: stretch; width: 100%; margin-top: var(--lumo-space-xl);"></vaadin-vertical-layout>
   </div>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="align-items: stretch; width: 50%; margin-right: var(--lumo-space-xl);">
   <vaadin-text-field placeholder="Placeholder" id="title" style="margin-top: 18%; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl);" readonly></vaadin-text-field>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-item style="align-self: flex-start; margin-left: var(--lumo-space-xl); margin-top: 10%;">
      Serial Number 
    </vaadin-item>
    <vaadin-text-field placeholder="Placeholder" id="serial" style="align-self: flex-end; flex-grow: 1; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-l);" readonly></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-item style="align-self: flex-start; flex-grow: 0; margin-left: var(--lumo-space-l);">
     Description 
   </vaadin-item>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-text-area label="" placeholder="" id="description" style="flex-grow: 1; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl);"></vaadin-text-area>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing">
    <vaadin-item style="align-self: flex-end; margin-left: var(--lumo-space-xl); flex-grow: 1;">
      Price 
    </vaadin-item>
    <vaadin-text-field placeholder="Placeholder" id="price" style="flex-grow: 0; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); flex-shrink: 0;" readonly></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: flex-end; flex-shrink: 1; flex-grow: 0;">
    <vaadin-text-field label="Quantita" id="quantita" value="1" placeholder="1" has-value></vaadin-text-field>
    <vaadin-button theme="tertiary" id="addCart" style="align-self: flex-end; margin-right: var(--lumo-space-xl); margin-left: var(--lumo-space-xl);">
     <iron-icon style="width: 29px; height: 29px;" icon="vaadin:cart-o"></iron-icon>
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'product-dialog';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProductDialog.is, ProductDialog);
