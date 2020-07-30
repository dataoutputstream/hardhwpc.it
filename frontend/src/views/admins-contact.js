import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-grid/src/vaadin-grid.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@polymer/iron-icon/iron-icon.js';

class AdminsContact extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout class="header" style="width: 100%; flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct);"></vaadin-horizontal-layout>
 <vaadin-horizontal-layout style="width: 100%; flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
  <vaadin-vertical-layout class="sidebar" style="flex-basis: calc(7*var(--lumo-size-s)); flex-shrink: 0; background-color: var(--lumo-contrast-5pct);">
   <vaadin-button theme="tertiary" id="scrivi" style="align-self: center; margin-top: 29%;">
     Scrivi 
   </vaadin-button>
   <vaadin-item style="align-self: center; margin-top: var(--lumo-space-m);">
     Messaggi Ricevuti 
   </vaadin-item>
   <vaadin-text-field label="" placeholder="" id="messageCounter" style="align-self: center; flex-shrink: 0; width: 28%;"></vaadin-text-field>
  </vaadin-vertical-layout>
  <vaadin-vertical-layout class="content" style="flex-grow: 1; flex-shrink: 1; flex-basis: auto;">
   <vaadin-grid id="messagesGrid"></vaadin-grid>
  </vaadin-vertical-layout>
 </vaadin-horizontal-layout>
 <vaadin-horizontal-layout class="footer" style="flex-basis: var(--lumo-size-l); flex-shrink: 0; background-color: var(--lumo-contrast-10pct); width: 100%;">
  <vaadin-horizontal-layout theme="spacing" style="align-self: center; flex-wrap: nowrap; margin-left: 48%; margin-top: var(--lumo-space-s); margin-bottom: var(--lumo-space-s);">
   <vaadin-button theme="icon" aria-label="Add new" id="backbutton">
    <iron-icon icon="lumo:arrow-left"></iron-icon>
   </vaadin-button>
   <vaadin-button theme="icon" aria-label="Add new" id="forwardbutton" style="margin-left: var(--lumo-space-xl);">
    <iron-icon icon="lumo:arrow-right"></iron-icon>
   </vaadin-button>
  </vaadin-horizontal-layout>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'admins-contact';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsContact.is, AdminsContact);
