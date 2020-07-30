import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `orders-view`
 *
 * OrdersView element.
 *
 * @customElement
 * @polymer
 */
class OrdersView extends PolymerElement {

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
        return 'orders-view';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(OrdersView.is, OrdersView);
