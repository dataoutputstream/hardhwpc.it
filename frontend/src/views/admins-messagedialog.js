import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-scroller.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class AdminsMessagedialog extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-scroller style="width: 100%; height: 100%;">
  <vaadin-vertical-layout theme="spacing" style="height: 100%;">
   <vaadin-horizontal-layout theme="spacing" style="height: 4%; width: 100%;background-color:gray;"></vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; flex-grow: 1; flex-shrink: 0; margin-top: var(--lumo-space-m);">
    <vaadin-item style="margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-m); align-self: flex-start;">
     Message: 
    </vaadin-item>
    <vaadin-text-area label="" placeholder="" id="messageText" style="flex-grow: 1; margin-top: var(--lumo-space-s); margin-right: var(--lumo-space-m);" readonly></vaadin-text-area>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="width: 100%; flex-grow: 0;">
    <vaadin-item style="margin-left: var(--lumo-space-l);">
     Email: 
    </vaadin-item>
    <vaadin-text-field id="email" style="width: 20%;"></vaadin-text-field>
    <vaadin-item>
     Title 
    </vaadin-item>
    <vaadin-text-field id="title" style="flex-grow: 1; margin-right: var(--lumo-space-m);"></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
    <vaadin-item style="margin-left: var(--lumo-space-l);">
     Name
    </vaadin-item>
    <vaadin-text-field id="userName" style="width: 20%;"></vaadin-text-field>
    <vaadin-item>
     Phone 
    </vaadin-item>
    <vaadin-text-field id="phoneNumber" style="width: 20%;"></vaadin-text-field>
    <vaadin-text-field  tabindex="0" has-label="" draggable="true" vaadin-dnd-layout-item="true" focused="" id="result" style="flex-grow: 1; margin-right: var(--lumo-space-m);"></vaadin-text-field>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch; flex-grow: 1;">
    <vaadin-item>
     OurMessage 
    </vaadin-item>
    <vaadin-text-area id="ourMessage" style="flex-grow: 1; margin-right: var(--lumo-space-m);"></vaadin-text-area>
   </vaadin-horizontal-layout>
   <vaadin-horizontal-layout theme="spacing" style="align-self: stretch;">
    <vaadin-button theme="tertiary" id="sendButton" style="flex-grow: 1;">
     Invia
    </vaadin-button>
   </vaadin-horizontal-layout>
  </vaadin-vertical-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 4%;background-color:gray"></vaadin-horizontal-layout>
 </vaadin-scroller>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'admins-messagedialog';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsMessagedialog.is, AdminsMessagedialog);
