import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class AdminsOrderview extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-top: var(--lumo-space-m);">
  <vaadin-combo-box id="orderbox" style="margin-left: var(--lumo-space-xl); margin-bottom: var(--lumo-space-s);" label="OrderBy.."></vaadin-combo-box>
  <vaadin-combo-box id="ordertype" style="margin-left: var(--lumo-space-xl);" label="OrderType"></vaadin-combo-box>
 </vaadin-horizontal-layout>
 <vaadin-text-field placeholder="Search" id="filter" style="margin-left: var(--lumo-space-l); width: 50%; margin-bottom: var(--lumo-space-m); margin-top: var(--lumo-space-m);"></vaadin-text-field>
 <vaadin-grid id="ordersGrid" style="margin-top: var(--lumo-space-m);"></vaadin-grid>
 <vaadin-horizontal-layout theme="spacing" style="align-self: center; margin-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-s);">
  <vaadin-button theme="icon" aria-label="Add new" id="backbutton">
   <iron-icon icon="lumo:arrow-left"></iron-icon>
  </vaadin-button>
  <vaadin-button theme="icon" aria-label="Add new" id="forwardbutton" style="margin-left: var(--lumo-space-xl);">
   <iron-icon icon="lumo:arrow-right"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'admins-orderview';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsOrderview.is, AdminsOrderview);
