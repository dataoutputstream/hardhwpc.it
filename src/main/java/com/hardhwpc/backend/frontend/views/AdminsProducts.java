package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the admins-products template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-products")
@JsModule("./src/views/admins-products.js")
public class AdminsProducts extends PolymerTemplate<AdminsProducts.AdminsProductsModel> {

    /**
     * Creates a new AdminsProducts.
     */
    public AdminsProducts() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between AdminsProducts and admins-products
     */
    public interface AdminsProductsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
