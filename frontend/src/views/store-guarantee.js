import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class StoreGuarantee extends PolymerElement {

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
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto; width: 100%; height: 100%;">
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%; font-size:150%;" readonly value="HardHwPcStore è un e-commerce nato in Italia e specializzato nella vendita di prodotti di Informatica, Telefonia, Elettronica e Giochi." has-value></vaadin-text-area>
   <vaadin-text-field style="flex-grow: 0; align-self: flex-start; width: 20%; margin-top: var(--lumo-space-xl); font-size:150%; margin-left: var(--lumo-space-s);" readonly value="Qualità dei prodotti
" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%;font-size:110%" readonly value="Un team di esperti seleziona i migliori prodotti del mercato italiano ed europeo per garantire qualità e innovazione al prezzo più vantaggioso. Sempre attenti alle ultime tecnologie, i nostri prodotti sono originali, nuovi e coperti da garanzia di 24 mesi (12 mesi in caso di acquisto da parte di un soggetto con partita Iva)." has-value></vaadin-text-area>
   <vaadin-text-field placeholder="Placeholder" style="margin-top: var(--lumo-space-xl); margin-left: var(--lumo-space-s); width: 20%;font-size:150%" readonly value="Affidabilità" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); align-self: stretch; margin-right: var(--lumo-space-s); width: 70%; font-size:110%" readonly value="La sicurezza è al primo posto per noi, per questo motivo ci affidiamo a sistemi di pagamenti sicuri e protetti come CartaSì e Banca Sella. I nostri clienti possono acquistare con Carta di Credito, PostePay o Bonifico  Bancario o comodamente pagare in contrassegno. Tiger Shop non è mai a conoscenza delle informazioni della carta di credito del Cliente." has-value></vaadin-text-area>
   <vaadin-text-field placeholder="Placeholder" style="margin-left: var(--lumo-space-s); width: 28%; margin-top: var(--lumo-space-xl);font-size:150%" readonly value="Rapidità dell’evasione" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%;font-size:110%" readonly value="Per tutti gli ordini dei prodotti con disponibilità immediata nel magazzino,HardHwPcStore garantisce un tempo di evasione dai 2 ai 5 giorni lavorativi. Grazie ai nostri centri di logistica basati su sistemi informativi avanzati, siamo in grado di tenere costantemente al corrente il cliente sulle disponibilità in magazzino, sull’accettazione e stato di avanzamento dell’ordine." has-value></vaadin-text-area>
   <vaadin-text-field placeholder="Placeholder" style="margin-left: var(--lumo-space-s); width: 28%; margin-top: var(--lumo-space-xl);font-size:150%" readonly value="Assistenza Clienti" has-value></vaadin-text-field>
   <vaadin-text-area style="margin-left: var(--lumo-space-s); margin-right: var(--lumo-space-s); align-self: stretch; width: 70%;font-size:110%" readonly value="HardHwPcStore garantisce un’assistenza al cliente (via mail o telefono) per guidarlo nella fase di pre-acquisto per la scelta del prodotto più adatto alle proprie esigenze o per avere informazioni sulla procedura di acquisto sul sito, e nella fase post-acquisto per la risoluzione di eventuali problemi. Per ricevere assistenza occorre compilare i form presentinella pagina contattaci. Ti risponderemo in massimo 48 ore, se non ricevi nessuna risposta all’indirizzo mail indicato ti invitiamo a controllare nello Spam." has-value></vaadin-text-area>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; "></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'store-guarantee';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(StoreGuarantee.is, StoreGuarantee);
