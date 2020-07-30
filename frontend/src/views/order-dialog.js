import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class OrderDialog extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1;">
   <iron-icon style="align-self: center; margin-left: var(--lumo-space-l);" icon="vaadin:archive"></iron-icon>
   <vaadin-text-field label="" placeholder="" style="margin-left: var(--lumo-space-s);" value="HARDHWPCSTORE"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" draggable="true" vaadin-dnd-layout-item="true">
   <vaadin-button theme="tertiary" style="flex-grow: 0;" id="exitButton">
    <iron-icon style="width: 30px; height: 30px;" icon="vaadin:close"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-5pct);"></vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
   <vaadin-grid id="productsGrid"></vaadin-grid>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <vaadin-item>
   HARDHWPCSTORE || Sede Legale non accessibile al publico || Via Roma 3 Taverna 88055 || P.IVA: 0x01010101
  </vaadin-item>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'order-dialog';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(OrderDialog.is, OrderDialog);
