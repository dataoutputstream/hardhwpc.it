import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-board/src/vaadin-board.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@polymer/iron-pages/iron-pages.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import './contact-us.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';

class MainView extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-20pct); height: 40%;">
  <vaadin-horizontal-layout theme="spacing" id="logoContainer" style="margin-top: var(--lumo-space-m); margin-left: var(--lumo-space-m);"></vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; margin-top: var(--lumo-space-m);">
   <vaadin-text-field placeholder="Search" style="align-self: center; margin-left: 4%; margin-bottom: 1%; width: 46%;" id="filter">
    <iron-icon icon="lumo:search" slot="prefix"></iron-icon>
   </vaadin-text-field>
   <iron-icon icon="vaadin:euro" style="align-self: center; margin-bottom: 1%; margin-left: 3%;"></iron-icon>
   <vaadin-text-field placeholder="Placeholder" style="width: 7%; flex-grow: 0; flex-shrink: 1; align-self: center; margin-bottom: 1%; margin-left: var(--lumo-space-m);" minlength="3px" readonly maxlength="50px" id="totalecarrello" value="0.00" has-value></vaadin-text-field>
   <vaadin-button theme="tertiary" style="margin-left: var(--lumo-space-m); flex-grow: 0; align-self: center; margin-bottom: 1%;" id="cartbutton">
    <iron-icon style="width: 27px; height: 27px;" icon="vaadin:cart"></iron-icon>
   </vaadin-button>
   <vaadin-text-field style="align-self: center; margin-bottom: 1%; margin-left: var(--lumo-space-s);" readonly id="nogetticarello" value="0 Oggetti nel carrello" has-value></vaadin-text-field>
   <vaadin-button theme="tertiary" style="align-self: center; margin-left: var(--lumo-space-xl); margin-bottom: var(--lumo-space-m);" id="userbutton">
    <iron-icon style="width: 27px; height: 27px;" icon="vaadin:user"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-20pct);">
  <vaadin-tabs style="flex-grow: 0; flex-shrink: 1; align: center; margin-left: 30%; align-self: center;" orientation="horizontal" selected="{{page}}">
   <vaadin-tab selected style="flex-grow: 0; flex-shrink: 0;">
     Tutti i prodotti 
   </vaadin-tab>
   <vaadin-tab>
     Contattaci 
   </vaadin-tab>
   <vaadin-tab>
     Chi Siamo 
   </vaadin-tab>
   <vaadin-tab>
     Termini e Condizioni 
   </vaadin-tab>
   <vaadin-tab disabled id="userTab"></vaadin-tab>
  </vaadin-tabs>
 </vaadin-horizontal-layout>
 <vaadin-scroller style="height: 100%; width: 100%; background-color: var(--lumo-contrast-10pct);">
  <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
   <vaadin-vertical-layout theme="spacing" style="width: 97%; height: 100%; align-self: flex-start; margin-left: 7%;">
    <vaadin-scroller style="width: 100%;">
     <iron-pages selected="[[page]]" ; style="width: 100%; flex-grow: 1;">
      <div style="width: 100%">
       <all-products id="allProducts"></all-products>
      </div>
      <div>
       <contact-us id="contactUs"></contact-us>
      </div>
      <div style="width: 100%;">
       <store-guarantee id="guarantee"></store-guarantee>
      </div>
      <div>
       <sepolicy-site id="sepolicySite"></sepolicy-site>
      </div>
     </iron-pages>
    </vaadin-scroller>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="tertiary" style="flex-grow: 1; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); width: 100%;">
   <vaadin-split-layout></vaadin-split-layout>
   <vaadin-vertical-layout theme="spacing" style="align-self: center; align-items: flex-start; margin-left: var(--lumo-space-xl); flex-grow: 1; margin: var(--lumo-space-xl);">
    <vaadin-board style="align-self: center; margin-left: 8%; margin-top: var(--lumo-space-xl);">
      HARDHWPCSTORE 
     <br content="Via Roma 3 Taverna 88055">Sede Legale non accessibile al publico 
     <br>Via Roma 3 Taverna 88055 
     <br>P.IVA: 0x01010101 
    </vaadin-board>
   </vaadin-vertical-layout>
   <vaadin-split-layout></vaadin-split-layout>
   <vaadin-vertical-layout theme="spacing" style="flex-grow: 1; flex-shrink: 0; margin-top: 50px; align-items: baseline; justify-content: flex-start;">
    <vaadin-list-box style="align-self: center; margin-right: var(--lumo-space-xl); margin-bottom: var(--lumo-space-xl);">
     <vaadin-button theme="tertiary" style="width: 500PX; flex-grow: 1;">
      <iron-icon _vaadin_designer_import_href="import 'http://localhost:52366/files/transformed/node_modules/@polymer/iron-icon/iron-icon.js';" draggable="true" vaadin-dnd-layout-item="true" style="margin-right: var(--lumo-space-s); width: 30px; height: 30px;" icon="vaadin:ambulance"></iron-icon>Assistenza 
     </vaadin-button>
     <vaadin-button theme="tertiary">
      <iron-icon style="margin-right: var(--lumo-space-s); width: 26px; height: 26px;" icon="vaadin:group"></iron-icon>Chi Siamo 
     </vaadin-button>
     <vaadin-button theme="tertiary">
      <iron-icon style="margin-right: var(--lumo-space-m); width: 27px; height: 27px;" icon="vaadin:gavel"></iron-icon>Termini 
     </vaadin-button>
     <vaadin-button theme="tertiary">
      <iron-icon style="margin-right: var(--lumo-space-s); width: 27px; height: 27px;" icon="vaadin:truck">
        Spedizioni 
      </iron-icon>Spedizioni 
     </vaadin-button>
    </vaadin-list-box>
   </vaadin-vertical-layout>
  </vaadin-horizontal-layout>
 </vaadin-scroller>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'main-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(MainView.is, MainView);
