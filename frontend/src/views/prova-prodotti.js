import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-form-layout/vaadin-form-layout.js';
import './gridproduct-item.js';

class ProvaProdotti extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-form-layout style="width: 100%; height: 100%;">
 <gridproduct-item></gridproduct-item>
 <gridproduct-item></gridproduct-item>
 <gridproduct-item></gridproduct-item>
</vaadin-form-layout>
`;
    }

    static get is() {
        return 'prova-prodotti';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(ProvaProdotti.is, ProvaProdotti);
