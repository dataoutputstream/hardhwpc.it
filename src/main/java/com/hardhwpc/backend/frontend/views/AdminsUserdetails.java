package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.hardhwpc.backend.support.exceptions.UserNotFoundException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;

/**
 * A Designer generated component for the admins-userdetails template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-userdetails")
@JsModule("./src/views/admins-userdetails.js")
public class AdminsUserdetails extends PolymerTemplate<AdminsUserdetails.AdminsUserdetailsModel> {

    @Id("backButton")
    private Button backButton;
    @Id("userOrders")
    private Grid<Order> userOrders;
    @Id("userName")
    private TextField userName;
    @Id("userEmail")
    private TextField userEmail;
    @Id("phoneNumber")
    private TextField phoneNumber;
    @Id("userType")
    private TextField userType;
    @Id("deleteUser")
    private Button deleteUser;
    AdminsUserview pointer;

    OrderService orderService;
    UserUtilsService userUtilsService;
    private User uniqueUser;
    private String tipo;


    /**
     * Creates a new AdminsUserdetails.
     */
    public AdminsUserdetails(OrderService orderService,UserUtilsService userUtilsService) {
        this.orderService=orderService;
        this.userUtilsService=userUtilsService;
        backButton.addClickListener(buttonClickEvent -> {
            // pointer.restoreView();
            this.getUI().ifPresent(ui -> {
                ui.removeAll();
                pointer.restoreView();

            });
        });
        deleteUser.addClickListener(buttonClickEvent -> {
            userUtilsService.delete(uniqueUser);
            backButton.click();
        });
        userOrders.addColumn(Order::getId).setHeader("OrderID");
        userOrders.addColumn(Order::getOrdernumber).setHeader("Order Number");
        userOrders.addColumn(Order::getShippingnumber).setHeader("Shipping Number");
        userOrders.addColumn(Order::getOrderstate).setHeader("Order State");
        userOrders.addColumn(Order::getPurchaseTime).setHeader("Purchase Time");

    }

    public void load(Set<User> selectedItems) {
        uniqueUser = (User) selectedItems.toArray()[0];
        try {
            userOrders.setItems(orderService.getOrderByUser(uniqueUser));
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
        userEmail.setValue(uniqueUser.getEmail());
        userName.setValue(uniqueUser.getLastName()+" "+uniqueUser.getFirstName());
        phoneNumber.setValue(uniqueUser.getTelephoneNumber());
        if(uniqueUser.getOrders().size()>2){
            tipo="Premium";
        }else tipo="Nuovo Utente";
        userType.setValue(tipo);
    }

    public void setPointer(AdminsUserview adminsUserview) {
        pointer=adminsUserview;

    }

    /**
     * This model binds properties between AdminsUserdetails and admins-userdetails
     */
    public interface AdminsUserdetailsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
