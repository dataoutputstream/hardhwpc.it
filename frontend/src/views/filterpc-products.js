import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

/**
 * `filterpc-products`
 *
 * FilterpcProducts element.
 *
 * @customElement
 * @polymer
 */
class FilterpcProducts extends PolymerElement {

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
        return 'filterpc-products';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(FilterpcProducts.is, FilterpcProducts);
