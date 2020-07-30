import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-login/src/vaadin-login-form.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-field.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';

class LoginUser extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout theme="spacing" style="align-items: stretch; height: 100%; width: 100%;">
 <vaadin-text-field style="align-self: center; width: 25%; margin-top: 12%;" value="  Effettua il Log-In per visulizzare le informazioni suoi tuoi ordini" has-value></vaadin-text-field>
 <vaadin-login-form id="vaadinLoginForm" style="align-self: center;"></vaadin-login-form>
 <vaadin-button id="registerButton" style="width: 45%; align-self: center;">
   Register 
 </vaadin-button>
 <vaadin-text-field style="margin-top: var(--lumo-space-m); width: 40%; align-self: center;" readonly id="messageField"></vaadin-text-field>
 <vaadin-item style="align-self: center;">
   Se non sei registrato ma hai acquistato dal nostro sito, registrati con l'email usata al momento dellìacquisto per recuperare info sull'ordine. 
 </vaadin-item>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'login-user';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(LoginUser.is, LoginUser);
