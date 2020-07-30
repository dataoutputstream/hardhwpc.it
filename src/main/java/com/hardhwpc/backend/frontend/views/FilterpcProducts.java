package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the filterpc-products template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("filterpc-products")
@JsModule("./src/views/filterpc-products.js")
public class FilterpcProducts extends PolymerTemplate<FilterpcProducts.FilterpcProductsModel> {

    /**
     * Creates a new FilterpcProducts.
     */
    public FilterpcProducts() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between FilterpcProducts and filterpc-products
     */
    public interface FilterpcProductsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
