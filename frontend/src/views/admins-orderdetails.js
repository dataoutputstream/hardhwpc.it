import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AdminsOrderdetails extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-button theme="tertiary" id="backButton" style="margin-top: var(--lumo-space-s); margin-left: var(--lumo-space-s); flex-grow: 0; flex-shrink: 1; align-self: flex-start; width: 10%; height: 10%;">
  <iron-icon style="width: 40%; height: 30%;" icon="lumo:arrow-left"></iron-icon>
 </vaadin-button>
 <vaadin-scroller style="width: 100%; height: 100%;">
  <vaadin-grid id="productsInOrder" style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s);"></vaadin-grid>
  <vaadin-horizontal-layout theme="spacing" style="margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-s);">
   <vaadin-text-field label="Order Number" id="orderNumber" style="margin-left: var(--lumo-space-m);"></vaadin-text-field>
   <vaadin-text-field label="User Email" placeholder="" id="userEmail" style="margin-left: var(--lumo-space-m);"></vaadin-text-field>
   <vaadin-text-field label="Current State" _vaadin_designer_import_href="import 'http://localhost:51984/files/transformed/node_modules/@vaadin/vaadin-text-field/theme/lumo/vaadin-text-field.js';" tabindex="0" has-label="" draggable="true" vaadin-dnd-layout-item="true" focused="" id="currentState" style="margin-left: var(--lumo-space-s);" readonly></vaadin-text-field>
   <vaadin-text-field id="purchaseTime" style="margin-left: var(--lumo-space-s);" readonly label="PurchaseTime"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" _vaadin_designer_import_href="import 'http://localhost:51984/files/transformed/node_modules/@vaadin/vaadin-ordered-layout/theme/lumo/vaadin-horizontal-layout.js';" draggable="true" vaadin-dnd-layout-item="true" style="margin-left: var(--lumo-space-m); margin-right: var(--lumo-space-m);">
   <vaadin-text-area label="Shipping Info Udater" id="shippingInfoUdater" style="flex-grow: 1;"></vaadin-text-area>
   <vaadin-button id="uploadButton" style="align-self: flex-end;">
    Upload 
   </vaadin-button>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="margin-top: var(--lumo-space-m); margin-left: var(--lumo-space-m); margin-right: var(--lumo-space-m);">
   <vaadin-item>
    Buyer want to delete order ?
   </vaadin-item>
   <vaadin-button theme="primary error" id="deleteButton">
    Delete Order
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-scroller>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'admins-orderdetails';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsOrderdetails.is, AdminsOrderdetails);
