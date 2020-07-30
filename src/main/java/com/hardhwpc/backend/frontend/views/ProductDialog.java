package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.frontend.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.awt.*;

/**
 * A Designer generated component for the product-dialog template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("product-dialog")
@JsModule("./src/views/product-dialog.js")
public class ProductDialog extends PolymerTemplate<ProductDialog.ProductDialogModel> {

    @Id("addCart")
    private Button addcart;
    @Id("title")
    private TextField title;
    @Id("img")
    private VerticalLayout img;
    @Id("price")
    private TextField price;
    @Id("description")
    private TextArea description;
    @Id("serial")
    private TextField serial;
    @Id("quantita")
    private TextField quantita;
    MainView puntatoreMainView;

    Product p;

    /**
     * Creates a new ProductDialog.
     */
    public ProductDialog() {
        // You can initialise any data required for the connected UI components here.
        addcart.addClickListener(buttonClickEvent -> {
            int quantità;
            if(quantita.getValue()=="")quantità=1; else quantità=Integer.valueOf(quantita.getValue());
        puntatoreMainView.aggiungiProdotto(p,quantità);
        });
    }

    public void mostra(Product p) {
        this.p=p;
        this.title.setValue(p.getName());
        Image  img =p.getImg();
        this.img.add(img);
        this.price.setValue(String.valueOf(p.getPrice()));
        this.description.setValue(p.getDescription());
        this.serial.setValue(p.getSerialnumber());
        Dialog d = new Dialog();
        d.setHeight("550px");
        d.setWidth("1000px");
        d.add(this);
        d.open();


    }

    public void setRef(MainView puntatoreMainView) {
        this.puntatoreMainView=puntatoreMainView;
    }

    /**
     * This model binds properties between ProductDialog and product-dialog
     */
    public interface ProductDialogModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
