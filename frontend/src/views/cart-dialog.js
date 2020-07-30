import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';

class CartDialog extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 88%;">
 <vaadin-horizontal-layout theme="spacing">
  <iron-icon style="align-self: center; width: 27px; height: 27px; margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-xl);" icon="vaadin:cart"></iron-icon>
  <vaadin-text-field style="align-self: center; flex-grow: 0; flex-shrink: 1; margin-top: var(--lumo-space-xl); margin-right: var(--lumo-space-xl);" readonly value="Carrello" has-value></vaadin-text-field>
  <iron-icon style="align-self: center; width: 27px; height: 27px; margin-top: var(--lumo-space-xl);" icon="vaadin:euro"></iron-icon>
  <vaadin-text-field style="align-self: center; margin-top: var(--lumo-space-xl);" id="totalecart" readonly has-value></vaadin-text-field>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; margin-top: var(--lumo-space-xl);">
  <vaadin-vertical-layout theme="spacing" id="vaadinVerticalLayout" style="align-self: stretch; flex-grow: 1; width: 50%; height: 100%;">
   <vaadin-grid id="productsGrid"></vaadin-grid>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%;">
 <vaadin-button theme="tertiary" style="width: 100%; height: 10%;" id="svuota">
   Svuota 
 </vaadin-button>
 <vaadin-button theme="tertiary" style="width: 100%; height: 10%;" id="chiudi">
   Chiudi 
 </vaadin-button>
 <vaadin-button theme="tertiary" style="width: 100%; height: 10%;" id="ordina">
   Ordina 
 </vaadin-button>
 <vaadin-button theme="tertiary" id="elimina" style="width: 100%; height: 10%;">
   Elimina 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'cart-dialog';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CartDialog.is, CartDialog);
