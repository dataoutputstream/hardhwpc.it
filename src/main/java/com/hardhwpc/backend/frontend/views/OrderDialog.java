package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.util.List;

@Tag("order-dialog")
@JsModule("./src/views/order-dialog.js")
public class OrderDialog extends PolymerTemplate<OrderDialog.OrderDialogModel> {
    @Id("productsGrid")
    private Grid<Product> productsGrid;
    List<Product> productsInOrder;
    @Id("exitButton")
    private Button exitButton;
    Dialog dialog;

    public OrderDialog(Order item) {
        dialog= new Dialog();
        productsInOrder=item.getProductsInOrder();
        productsGrid.addColumn(Product::getName).setHeader("Name");
        productsGrid.addColumn(Product::getPrice).setHeader("Price");
        productsGrid.addColumn(Product::getProductcode).setHeader("Product Code");
        productsGrid.addColumn(Product::getSerialnumber).setHeader("Serial Number");
        productsGrid.setItems(productsInOrder);

        exitButton.addClickListener(buttonClickEvent -> {
            dialog.close();
        });

        dialog.setSizeUndefined();
        dialog.add(this);
        dialog.setCloseOnOutsideClick(false);
        dialog.open();
    }

    public interface OrderDialogModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
