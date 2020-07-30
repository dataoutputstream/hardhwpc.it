import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-icons/vaadin-icons.js';
import '@vaadin/vaadin-board/src/vaadin-board.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import '@vaadin/vaadin-split-layout/src/vaadin-split-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@polymer/iron-pages/iron-pages.js';
import './admins-orderview.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-tabs/src/vaadin-tabs.js';
import './admins-userview.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-tabs/src/vaadin-tab.js';
import './admins-contact.js';

class AdminPage extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-vertical-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-20pct); height: 40%;">
  <vaadin-horizontal-layout theme="spacing" style="flex-grow: 1; margin-top: var(--lumo-space-m);">
   <vaadin-horizontal-layout theme="spacing" id="logoContainer" style="margin-top: var(--lumo-space-m); margin-left: var(--lumo-space-m); align-self: stretch;"></vaadin-horizontal-layout>
   <vaadin-tabs style="flex-grow: 1; flex-shrink: 0; align: center; margin-left: 40%; align-self: center;" orientation="horizontal" selected="{{page}}">
    <vaadin-tab selected style="flex-grow: 0; flex-shrink: 0;" id="vaadinTab">
      Ordini 
    </vaadin-tab>
    <vaadin-tab id="vaadinTab1">
      Utenti 
    </vaadin-tab>
    <vaadin-tab>
      Centro Messaggistica 
    </vaadin-tab>
   </vaadin-tabs>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-scroller style="height: 100%; width: 100%;background-color: var(--lumo-contrast-10pct);">
  <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%;" id="vaadinVerticalLayout">
   <vaadin-vertical-layout theme="spacing" style="width: 100%; height: 100%; align-self: flex-start; margin-left: 7%;">
    <vaadin-scroller style="width: 100%; height: 100%;">
     <iron-pages selected="[[page]]" ; style="width: 100%; flex-grow: 1; height: 100%;">
      <div style="width: 100%; height: 100%;">
       <admins-orderview id="adminsOrderView" style="width: 85%; height: 100%;"></admins-orderview>
      </div>
      <div style="width: 100%; height: 100%;">
       <admins-userview id="adminsUserview" style="width: 85%;"></admins-userview>
      </div>
      <div style="width: 100%; height: 100%;">
       <admins-contact id="adminsContact" style="width: 85%;"></admins-contact>
      </div>
     </iron-pages>
    </vaadin-scroller>
   </vaadin-vertical-layout>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="tertiary" style="flex-grow: 1; flex-direction: row; flex-wrap: wrap; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);">
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
    <vaadin-list-box style="align-self: center; margin-right: var(--lumo-space-xl); margin-bottom: var(--lumo-space-xl);"></vaadin-list-box>
   </vaadin-vertical-layout>
   <vaadin-split-layout></vaadin-split-layout>
  </vaadin-horizontal-layout>
 </vaadin-scroller>
</vaadin-vertical-layout>
<div style="margin: var(--lumo-space-s);"></div>
`;
    }

    static get is() {
        return 'admin-page';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminPage.is, AdminPage);
