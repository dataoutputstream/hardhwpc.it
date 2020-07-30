package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

/**
 * A Designer generated component for the orders-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("orders-view")
@JsModule("./src/views/orders-view.js")
public class OrdersView extends PolymerTemplate<OrdersView.OrdersViewModel> {

    /**
     * Creates a new OrdersView.
     */
    public OrdersView() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between OrdersView and orders-view
     */
    public interface OrdersViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
