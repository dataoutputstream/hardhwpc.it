import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `admins-products`
 *
 * AdminsProducts element.
 *
 * @customElement
 * @polymer
 */
class AdminsProducts extends PolymerElement {

    static get template() {
        return html`
            <style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
        `;
    }

    static get is() {
        return 'admins-products';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(AdminsProducts.is, AdminsProducts);
