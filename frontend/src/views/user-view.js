import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class UserView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%; background-color: var(--lumo-contrast-5pct);">
 <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; background-color: var(--lumo-contrast-5pct);">
  <vaadin-text-field id="welcomeText" style="margin-top: var(--lumo-space-s); margin-left: var(--lumo-space-xl);" title="welcomeText" readonly></vaadin-text-field>
  <vaadin-horizontal-layout style="flex-grow: 0; flex-shrink: 0; margin-left: 75%;">
   <vaadin-button theme="tertiary" id="exitButton" style="margin-top: var(--lumo-space-m); flex-grow: 0;">
     Esci dall'area utente 
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto; background-color: var(--lumo-contrast-5pct); width: 60%;">
   <vaadin-grid id="ordersGrid" style="flex-grow: 1; flex-shrink: 0; margin-left: var(--lumo-space-m);" loading></vaadin-grid>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-5pct); width: 50%; flex-grow: 1;">
   <vaadin-horizontal-layout theme="spacing" style="margin-top: 40%;">
    <vaadin-item style="margin-left: var(--lumo-space-l);">
      N.Ordine 
    </vaadin-item>
    <vaadin-combo-box id="orderBox" style="margin-left: var(--lumo-space-m);"></vaadin-combo-box>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="margin-left: var(--lumo-space-m); align-self: stretch; margin-right: var(--lumo-space-m); margin-top: var(--lumo-space-m);">
    <vaadin-item>
      Titolo 
    </vaadin-item>
    <vaadin-text-field id="messageTitle" style="flex-grow: 1;"></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-text-area label="Messaggio Rapido " placeholder="Invia il tuo messaggio" id="messageText" style="flex-grow: 0; align-self: stretch; height: 20%; margin: var(--lumo-space-m);"></vaadin-text-area>
   <vaadin-button theme="primary" id="messageButton" style="align-self: flex-end; margin-right: var(--lumo-space-m);">
     Invia 
   </vaadin-button>
   <vaadin-text-field id="result" style="align-self: stretch; margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-l); margin-top: var(--lumo-space-s);" readonly></vaadin-text-field>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
  <vaadin-item style="margin-left: var(--lumo-space-s);">
    HARDHWPCSTORE || Sede Legale non accessibile al publico || Via Roma 3 Taverna 88055 || P.IVA: 0x01010101 
  </vaadin-item>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'user-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(UserView.is, UserView);
