import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';

class ContactUs extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; "></vaadin-horizontal-layout>
 <vaadin-scroller style="width: 100%; height: 100%;">
  <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
   <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; height: text;"></vaadin-vertical-layout>
   <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
    <vaadin-text-field style="margin-left: var(--lumo-space-xl); font-size:200%;" readonly value="Contattacci" has-value></vaadin-text-field>
    <vaadin-text-area label="" placeholder="" style="margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl); margin-top: var(--lumo-space-l); width: 70%;" value="Al fine di offrirti il miglior servizio possibile, ti preghiamo di fornirci alcune indicazioni compilando il seguente modulo. I campi contrassegnati dall'asterisco (*) sono obbligatori. Risponderemo alla tua richiesta il prima possibile." has-value></vaadin-text-area>
    <vaadin-horizontal-layout theme="spacing" style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); align-self: stretch; margin-right: var(--lumo-space-l);">
     <vaadin-text-field label="Cognome e Nome" id="name" style="width: 30%;" required invalid></vaadin-text-field>
     <vaadin-text-field label="Email" id="email" style="width: 30%;" required invalid></vaadin-text-field>
    </vaadin-horizontal-layout>
    <vaadin-horizontal-layout theme="spacing" style="margin-left: var(--lumo-space-xl); margin-top: var(--lumo-space-s); margin-right: var(--lumo-space-l); align-self: stretch;">
     <vaadin-text-field label="Telefono" id="phone_number" style="width: 30%;"></vaadin-text-field>
     <vaadin-text-field label="Order Number" id="orderNumber" style="width: 30%;"></vaadin-text-field>
    </vaadin-horizontal-layout>
    <vaadin-text-field label="Richiesta" placeholder="Titolo del messaggio" id="messageHeader" style="width: 70%; margin-left: var(--lumo-space-xl); margin-top: var(--lumo-space-s);" required invalid></vaadin-text-field>
    <vaadin-text-area label="Messaggio" placeholder="Scrivi il tuo messaggio" id="messageText" style="margin-top: var(--lumo-space-s); margin-left: var(--lumo-space-xl); align-self: stretch; margin-right: var(--lumo-space-l); height: 30%; width: 70%; flex-grow: 1; flex-shrink: 1;" required invalid></vaadin-text-area>
    <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-left: var(--lumo-space-m); margin-top: var(--lumo-space-m);">
     <vaadin-text-field tabindex="0" has-label="" draggable="true" vaadin-dnd-layout-item="true" focused="" id="result" style="margin-left: var(--lumo-space-xl); align-self: flex-end; width: 38%; margin-top: var(--lumo-space-s);" readonly></vaadin-text-field>
     <vaadin-button theme="tertiary" tabindex="0" role="button" draggable="true" vaadin-dnd-layout-item="true" style="align-self: center; margin-left: 26%; flex-grow: 0; flex-shrink: 0; width: 10%;" id="sendButton" active="" focused="">
      <iron-icon style="width: 30%; height: 30%;" icon="lumo:upload"></iron-icon>
     </vaadin-button>
    </vaadin-horizontal-layout>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-scroller>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; "></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'contact-us';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ContactUs.is, ContactUs);
