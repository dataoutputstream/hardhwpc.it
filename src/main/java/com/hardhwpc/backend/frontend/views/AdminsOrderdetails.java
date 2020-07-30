package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.support.exceptions.UserNotFoundException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.PreRemove;
import java.math.BigInteger;
import java.util.List;
import java.util.Set;

/**
 * A Designer generated component for the admins-orderdetails template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-orderdetails")
@JsModule("./src/views/admins-orderdetails.js")
public class AdminsOrderdetails extends PolymerTemplate<AdminsOrderdetails.AdminsOrderdetailsModel> {

    @Id("backButton")
    private Button backButton;
    @Id("orderNumber")
    private TextField orderNumber;
    @Id("userEmail")
    private TextField userEmail;
    @Id("currentState")
    private TextField currentState;
    @Id("purchaseTime")
    private TextField purchaseTime;
    @Id("shippingInfoUdater")
    private TextArea shippingInfoUdater;
    @Id("uploadButton")
    private Button uploadButton;
    @Id("deleteButton")
    private Button deleteButton;
    AdminsOrderview pointer;
    OrderService orderService;
    Order uniqueOrder;
    @Id("productsInOrder")
    private Grid<Product> productsInOrder;



    /**
     * Creates a new AdminsOrderdetails.
     */

    public AdminsOrderdetails(OrderService orderService) {
        this.orderService=orderService;
        backButton.addClickListener(buttonClickEvent -> {
           // pointer.restoreView();
            this.getUI().ifPresent(ui -> {
                    ui.removeAll();
                    pointer.restoreView();

            });
        });
        uploadButton.addClickListener(buttonClickEvent -> {
            uniqueOrder.setShippingnumber(shippingInfoUdater.getValue());
            uniqueOrder.setOrderstate("Spedito");
            orderService.addOrder(uniqueOrder);
        });
        deleteButton.addClickListener(buttonClickEvent -> {
            remove();
        });
        productsInOrder.addColumn(Product::getName).setHeader("Name");
        productsInOrder.addColumn(Product::getPrice).setHeader("Price");
        productsInOrder.addColumn(Product::getProductcode).setHeader("Product Code");
        productsInOrder.addColumn(Product::getSerialnumber).setHeader("Serial Number");
    }

    public void setPointer(AdminsOrderview adminsOrderview) {
        pointer=adminsOrderview;
    }

    public void load(Set<Order> selectedItems) {
        uniqueOrder= (Order) selectedItems.toArray()[0];
        if(uniqueOrder.getOrdernumber()!=null)
        orderNumber.setValue(uniqueOrder.getOrdernumber());
        userEmail.setValue(uniqueOrder.getBuyer().getEmail());
        currentState.setValue(uniqueOrder.getOrderstate());
        purchaseTime.setValue(uniqueOrder.getPurchaseTime().toString());
        List<Product> productsList=uniqueOrder.getProductsInOrder();
        productsInOrder.setItems(productsList);
    }


    public void remove(){
        orderService.removeOrder(uniqueOrder.getId());
    }



    /**
     * This model binds properties between AdminsOrderdetails and admins-orderdetails
     */
    public interface AdminsOrderdetailsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
