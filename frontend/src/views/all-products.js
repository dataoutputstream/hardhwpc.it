import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AllProducts extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" _vaadin_designer_import_href="import 'http://localhost:51557/files/transformed/node_modules/@vaadin/vaadin-ordered-layout/theme/lumo/vaadin-vertical-layout.js';" draggable="true" vaadin-dnd-layout-item="true" style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing">
  <vaadin-combo-box id="orderbox" style="align-self: center; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xl); flex-grow: 0; flex-shrink: 1;" label="Order by" loading></vaadin-combo-box>
  <vaadin-combo-box id="ordertype" style="align-self: center; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xl);" label="Ascendent/Descendent" loading></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" id="productsGrid" style="width: 100%; height: 100%; margin-right: var(--lumo-space-xl);"></vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing" _vaadin_designer_import_href="import 'http://localhost:50087/files/transformed/node_modules/@vaadin/vaadin-ordered-layout/theme/lumo/vaadin-horizontal-layout.js';" draggable="true" vaadin-dnd-layout-item="true" style="width: 100%;">
  <vaadin-button theme="tertiary" style="align-self: center; margin-left: 46%;" id="backbutton">
    Indietro 
  </vaadin-button>
  <vaadin-button theme="tertiary" id="forwardbutton">
    Avanti 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'all-products';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AllProducts.is, AllProducts);
