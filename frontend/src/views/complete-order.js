import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-item.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@vaadin/vaadin-form-layout/src/vaadin-form-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-combo-box/src/vaadin-combo-box.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class CompleteOrder extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 90%; height: 100%;">
 <vaadin-vertical-layout theme="spacing" style="width: 20%;background-color: var(--lumo-contrast-20pct);"></vaadin-vertical-layout>
 <vaadin-scroller style="width: 100%; height: 100%; align-self: flex-start;">
  <vaadin-vertical-layout theme="spacing" style="width: 100%; align-items: center; justify-content: space-evenly; flex-wrap: wrap; margin-left: 30%;">
   <label style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-xl); color:gray; align-self: stretch; flex-grow: 0; flex-shrink: 1;"><h3 style="padding-top: var(--lumo-space-xs);">Inserisci i dati utili alla spedizione:</h3></label>
   <vaadin-form-layout style="flex-grow: 1; align-self: stretch; width: 100%;">
    <vaadin-vertical-layout style="flex-direction: column; justify-content: space-between; align-items: stretch; width: 100%;">
     <vaadin-horizontal-layout style="flex-direction: row; flex-grow: 0; width: 100%;">
      <iron-icon style="width: 27px; height: 27px; margin-top: var(--lumo-space-l); align-self: center; margin-left: var(--lumo-space-m);" icon="lumo:user"></iron-icon>
     </vaadin-horizontal-layout>
     <vaadin-vertical-layout theme="spacing" style="width: 100%;">
      <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: stretch;">
       <vaadin-text-field label="Nome" style="flex-grow: 1; margin-left: var(--lumo-space-l);" required invalid id="nomesped"></vaadin-text-field>
       <vaadin-text-field label="Cognome" style="flex-grow: 1; margin-left: var(--lumo-space-l); margin-right: var(--lumo-space-m);" required invalid id="shiplastname"></vaadin-text-field>
      </vaadin-horizontal-layout>
      <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
       <vaadin-text-field label="E-mail *" style="flex-grow: 1; margin-left: var(--lumo-space-l);" required autoselect autofocus invalid id="emailship"></vaadin-text-field>
       <vaadin-text-field label="Password" id="password" style="flex-grow: 1; margin-right: var(--lumo-space-m);" required invalid></vaadin-text-field>
      </vaadin-horizontal-layout>
      <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
       <vaadin-text-area label="Indirizzo" placeholder="Indirizzo, Citta, Provincia, Cap" style="width: 100%; margin-right: var(--lumo-space-l); margin-left: var(--lumo-space-l); flex-grow: 1;" autofocus autoselect required invalid id="addresship"></vaadin-text-area>
      </vaadin-horizontal-layout>
      <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-right: var(--lumo-space-m);">
       <vaadin-text-field label="P.Iva / Codice Fiscale" style="margin-left: var(--lumo-space-l); flex-grow: 0; width: 50%; margin-right: var(--lumo-space-xl);" required id="pivaship" invalid></vaadin-text-field>
       <vaadin-text-field label="Telefono" style="flex-grow: 1; margin-right: var(--lumo-space-m);" autoselect autofocus required id="telship" invalid></vaadin-text-field>
      </vaadin-horizontal-layout>
     </vaadin-vertical-layout>
    </vaadin-vertical-layout>
   </vaadin-form-layout>
   <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; height: 50%; align-self: stretch; width: 100%;">
    <vaadin-checkbox id="fatturazioneDiversa" style="margin-left: var(--lumo-space-m);" checked>
     <iron-icon icon="lumo:user" style="vertical-align: top;"></iron-icon>Dati di fatturazione diversi da quelli di spedizione o aggiuntivi 
    </vaadin-checkbox>
    <vaadin-form-layout style="flex-grow: 1; align-self: stretch;" id="invoiceform">
     <vaadin-vertical-layout style="height: 100%; flex-direction: column; width: 100%;">
      <vaadin-vertical-layout theme="spacing" style="width: 100%;">
       <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: stretch;">
        <vaadin-text-field label="Nome/RagioneSociale" style="flex-grow: 1; margin-left: var(--lumo-space-l);" required invalid id="invname" tabindex=""></vaadin-text-field>
        <vaadin-text-field label="Codice Fiscale" style="flex-grow: 1; margin-left: var(--lumo-space-l); margin-right: var(--lumo-space-m);" required invalid id="invfisccode" tabindex=""></vaadin-text-field>
       </vaadin-horizontal-layout>
       <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
        <vaadin-text-field label="E-mail / PEC*" style="flex-grow: 1; margin-left: var(--lumo-space-l);" required autoselect autofocus invalid id="email" tabindex=""></vaadin-text-field>
        <vaadin-text-field label="Codice Univoco" style="flex-grow: 1; margin-right: var(--lumo-space-m);" autoselect autofocus required invalid id="invuid" tabindex=""></vaadin-text-field>
       </vaadin-horizontal-layout>
       <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; margin-right: var(--lumo-space-m);">
        <vaadin-text-field label="P.Iva" style="margin-left: var(--lumo-space-l); flex-grow: 0; width: 50%; margin-right: var(--lumo-space-xl);" id="invpiva" tabindex=""></vaadin-text-field>
       </vaadin-horizontal-layout>
      </vaadin-vertical-layout>
     </vaadin-vertical-layout>
    </vaadin-form-layout>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
 </vaadin-scroller>
 <vaadin-vertical-layout theme="spacing" style="width: 70%; margin-left: var(--lumo-space-xl); margin-right: var(--lumo-space-xl);">
  <vaadin-vertical-layout theme="spacing" style="height: 50%; align-self: stretch; margin-top: var(--lumo-space-l);">
   <vaadin-button theme="icon" aria-label="Add new" id="backbutton" style="align-self: flex-end; margin-top: var(--lumo-space-xl);">
    <iron-icon icon="lumo:cross"></iron-icon>
   </vaadin-button>
   <vaadin-horizontal-layout theme="spacing" style="margin-top: 20%; align-self: stretch;">
    <vaadin-combo-box id="paytype" style="align-self: flex-end; margin-left: var(--lumo-space-xl); width: 60%;" required label="Seleziona il tipo di pagamento"></vaadin-combo-box>
    <vaadin-button theme="primary " id="orderButton" style="margin-top: 8.8%; margin-left: 10%; height: 50%; width: 30%; align-self: flex-end;">
      Ordina 
    </vaadin-button>
   </vaadin-horizontal-layout>
   <vaadin-text-area label="Scrivi un messaggio per il venditore." placeholder="Aggiungi qualche informazione utile riguardo all'ordine o alla spedizione." style="align-self: stretch; flex-grow: 0; margin-top: var(--lumo-space-xl); margin-right: var(--lumo-space-xl); height: 40%; margin-left: var(--lumo-space-l);" id="infoorder">
     Text 
   </vaadin-text-area>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout theme="spacing" style="align-self: stretch; flex-grow: 1; margin-right: 5%;">
   <vaadin-text-area placeholder="Add detailed explanation" id="result" style="align-self: stretch; margin-right: var(--lumo-space-s); margin-left: var(--lumo-space-l); height: 30%; margin-top: var(--lumo-space-xl);" readonly></vaadin-text-area>
  </vaadin-vertical-layout>
 </vaadin-vertical-layout>
</vaadin-horizontal-layout>
<vaadin-button theme="icon" aria-label="Add new">
 <iron-icon icon="lumo:plus"></iron-icon>
</vaadin-button>
`;
    }

    static get is() {
        return 'complete-order';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(CompleteOrder.is, CompleteOrder);
