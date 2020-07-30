import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';

class AdminsUserdetails extends PolymerElement {

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
  <vaadin-grid id="userOrders" style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s);"></vaadin-grid>
  <vaadin-horizontal-layout theme="spacing" style="margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-s);">
   <vaadin-text-field label="User Name" id="userName" style="margin-left: var(--lumo-space-m);"></vaadin-text-field>
   <vaadin-text-field label="User Email" placeholder="" id="userEmail" style="margin-left: var(--lumo-space-m);"></vaadin-text-field>
   <vaadin-text-field label="Phone Number" _vaadin_designer_import_href="import 'http://localhost:51984/files/transformed/node_modules/@vaadin/vaadin-text-field/theme/lumo/vaadin-text-field.js';" tabindex="0" has-label="" draggable="true" vaadin-dnd-layout-item="true" focused="" id="phoneNumber" style="margin-left: var(--lumo-space-s);" readonly></vaadin-text-field>
   <vaadin-text-field id="userType" style="margin-left: var(--lumo-space-s);" readonly label="User Fedelitity"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" _vaadin_designer_import_href="import 'http://localhost:51984/files/transformed/node_modules/@vaadin/vaadin-ordered-layout/theme/lumo/vaadin-horizontal-layout.js';" draggable="true" vaadin-dnd-layout-item="true" style="margin-left: var(--lumo-space-m); margin-right: var(--lumo-space-m);"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="margin-top: var(--lumo-space-m); margin-left: var(--lumo-space-m); margin-right: var(--lumo-space-m);">
   <vaadin-item>
     Delete User Profile 
   </vaadin-item>
   <vaadin-button theme="primary error" id="deleteUser">
     Delete User 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-scroller>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'admins-userdetails';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsUserdetails.is, AdminsUserdetails);
