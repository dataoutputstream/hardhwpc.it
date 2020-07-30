import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class SepolicySite extends PolymerElement {

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
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; "></vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
   <vaadin-text-field style="flex-grow: 1; margin-left: var(--lumo-space-s); font-size:150%; margin-top: var(--lumo-space-m); flex-shrink: 0; width: 30%;" readonly value="PRODOTTO ITALIANO?
" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%; margin-top: var(--lumo-space-s); font-size:110%; flex-grow: 1;" readonly value="Tutti i nostri prodotti sono venduti compatibili per il territorio italiano con lingua italiana con relativa ricevuta legale per la garanzia del territorio italiano di 24 mesi. Tutti i nostri prodotti hanno assistenza tecnica sul territorio italiano con tempi rapidi e veloci per l’assistenza. I nostri prodotti sono per la distribuzione dell’unione europea potresti non trovare i manuali con la lingua italiana." has-value></vaadin-text-area>
   <vaadin-text-field placeholder="Placeholder" style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-s); font-size:150%; flex-shrink: 0; width: 32%; flex-grow: 1;" readonly value="GARANZIA LEGALE 24 MESI" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); align-self: stretch; margin-right: var(--lumo-space-s); width: 70%; margin-top: var(--lumo-space-s); font-size:110%; flex-grow: 1;" readonly value="Tutti i prodotti venduti da questo Shop sono venduti e spediti da azienda italiana quindi la garanzia vige sul territorio italiano come previsto dagli artt. 128-135 del Codice del Consumo (“Garanzia Legale”) per la durata di 24 mesi. Maggiori informazioni sono disponibili nelle condizioni di vendita.  Maggiori informazioni sono disponibili nelle condizioni di vendita." has-value></vaadin-text-area>
   <vaadin-text-field placeholder="Placeholder" style="margin-left: var(--lumo-space-s); margin-top: var(--lumo-space-xl); font-size: 150%; width: 45%; flex-grow: 1;" readonly value="DIRITTO DI RECESSO ENTRO 14 GIORNI
" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%; flex-grow: 1; font-size:110%" readonly value="Se cambi idea e vuoi restituire quanto acquistato, no problem! Effettua una comunicazione entra 14 giorni da quando ti viene consegnato il prodotto. Può esercitare questo diritto esclusivamente il cliente-consumatore, ovvero la persona fisica che acquista la merce per scopi non riferibili alla propria attività professionale e che quindi non indica nel modulo d’ordine un riferimento di Partita Iva. Per maggiori informazioni consulta le modalità per effettuare il reso." has-value></vaadin-text-area>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; "></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'sepolicy-site';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(SepolicySite.is, SepolicySite);
