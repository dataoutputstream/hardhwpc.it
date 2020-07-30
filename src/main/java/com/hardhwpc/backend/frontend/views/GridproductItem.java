package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.frontend.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the gridproduct-item template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("gridproduct-item")
@JsModule("./src/views/gridproduct-item.js")
public class GridproductItem extends PolymerTemplate<GridproductItem.GridproductItemModel> {

    @Id("img")
    private VerticalLayout img;
    @Id("name")
    private TextField name;
    @Id("description")
    private TextArea description;
    MainView puntatoreMainView;



    @Id("productprice")
    private TextField productprice;

    public VerticalLayout getLayout() {
        return layout;
    }

    public void setLayout(VerticalLayout layout) {
        this.layout = layout;
    }

    @Id("layout")
    private VerticalLayout layout;

    public VerticalLayout getImg() {
        return img;
    }

    public void setImg(Image img) {
        this.img.removeAll();
        this.img.add(img);
    }

    public String getName() {
        return this.name.getValue();
    }

    public void setName(String name) {
        this.name.setValue(name);
    }

    public String getDescription() {
        return  this.description.getValue();
    }

    public void setDescription(String description) {
        this.description.setValue(description);
    }

    public Double getProductprice() {
        return Double.valueOf(productprice.getValue());
    }

    public void setProductprice(Double productprice) {
        this.productprice.setValue(String.valueOf(productprice));
    }


    /**
     * Creates a new GridproductItem.
     */
    public GridproductItem() {
        // You can initialise any data required for the connected UI components here.
    }

    public void setRef(MainView puntatoreMainView) {
        this.puntatoreMainView=puntatoreMainView;
    }

    /**
     * This model binds properties between GridproductItem and gridproduct-item
     */
    public interface GridproductItemModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
