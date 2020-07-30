import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@polymer/iron-icon/iron-icon.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';

class UserRegistration extends PolymerElement {


    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" style="flex-direction: row; flex-grow: 0; align-self: stretch;">
  <iron-icon style="width: 27px; height: 27px; margin-top: var(--lumo-space-l); margin-left: var(--lumo-space-xl); align-self: center;" icon="lumo:user"></iron-icon>
  <vaadin-text-field style="align-self: center; margin-top: var(--lumo-space-m); margin-left: var(--lumo-space-s);" value="Sign-Up" readonly has-value>
    Registrati 
  </vaadin-text-field>
  <vaadin-button theme="icon" aria-label="Add new" style="align-self: center; margin-top: var(--lumo-space-m); flex-grow: 0; margin-left: 64%;" id="closeButton">
   <iron-icon icon="lumo:cross"></iron-icon>
  </vaadin-button>
 </vaadin-horizontal-layout>
 <vaadin-vertical-layout theme="spacing" style="width: 100%;">
  <vaadin-horizontal-layout theme="spacing" style="width: 100%; align-self: stretch;">
   <vaadin-text-field label="E-mail *" style="flex-grow: 1; margin-left: var(--lumo-space-l);" required autoselect autofocus id="email" invalid></vaadin-text-field>
   <vaadin-text-field label="Password*" style="flex-grow: 1; margin-right: var(--lumo-space-m);" required autoselect autofocus id="password" invalid></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
   <vaadin-text-field label="Telefono" style="flex-grow: 1; margin-right: var(--lumo-space-m); margin-left: var(--lumo-space-l);" autoselect autofocus id="telephone"></vaadin-text-field>
   <vaadin-text-field id="name" style="align-self: flex-end; flex-grow: 1; margin-right: var(--lumo-space-m);" label="Nome"></vaadin-text-field>
   <vaadin-text-field label="Cognome" id="lastname" style="flex-grow: 1;"></vaadin-text-field>
  </vaadin-horizontal-layout>
  <vaadin-horizontal-layout theme="spacing" style="width: 100%;">
   <vaadin-text-area label="Indirizzo" placeholder="Indirizzo, Città, Provincia, Cap" style="width: 100%; margin-right: var(--lumo-space-l); margin-left: var(--lumo-space-l);" autofocus autoselect id="address"></vaadin-text-area>
  </vaadin-horizontal-layout>
 </vaadin-vertical-layout>
 <vaadin-horizontal-layout theme="spacing" style="align-self: flex-end; margin-top: var(--lumo-space-xl); width: 100%;">
  <vaadin-text-field style="flex-grow: 1; margin-left: var(--lumo-space-xl);" readonly disabled id="message" tabindex=""></vaadin-text-field>
  <vaadin-button theme="primary success" style="align-self: flex-end; flex-grow: 0; margin-left: var(--lumo-space-m); margin-right: var(--lumo-space-xl);" id="register">
    Registrati 
  </vaadin-button>
 </vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'user-registration';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(UserRegistration.is, UserRegistration);