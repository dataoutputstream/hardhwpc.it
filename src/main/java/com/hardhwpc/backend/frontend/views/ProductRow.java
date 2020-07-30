package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the product-row template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("product-row")
@JsModule("./src/views/product-row.js")
public class ProductRow extends PolymerTemplate<ProductRow.ProductRowModel> {


    @Id("vaadinHorizontalLayout")
    private HorizontalLayout riga;

    /**
     * Creates a new ProductRow.
     */
    public ProductRow() {
        // You can initialise any data required for the connected UI components here.
    }

    public void add(GridproductItem gridproductItem) {
        riga.add(gridproductItem);
    }

    /**
     * This model binds properties between ProductRow and product-row
     */
    public interface ProductRowModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
