package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.BillingData;
import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.UserUtilsService;
import com.hardhwpc.backend.support.exceptions.UserAlreadyExistException;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * A Designer generated component for the user-registration template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-registration")
@JsModule("./src/views/user-registration.js")
public class UserRegistration extends PolymerTemplate<UserRegistration.UserRegistrationModel> {

    @Id("closeButton")
    private Button closeButton;
    Button userRegistration;
    Dialog dialogRegitration;
    @Id("password")
    private TextField password;
    @Id("email")
    private TextField email;
    @Id("telephone")
    private TextField telephone;
    @Id("address")
    private TextArea address;
    @Id("message")
    private TextField message;
    @Id("register")
    private Button register;
    @Id("lastname")
    private TextField lastname;
    @Id("name")
    private TextField name;
    UserUtilsService userUtilsService;
    User u;

    /**
     * Creates a new UserRegistration.
     */
    @Autowired
    public UserRegistration(UserUtilsService userUtilsService) {
        this.userUtilsService=userUtilsService;
        dialogRegitration=new Dialog();
            closeButton.addClickListener(buttonClickEvent1 -> {
                dialogRegitration.close();
            });

        Binder<User> binder = new Binder<>(User.class);
        binder.setBean(new User());
        binder.forField(telephone).bind(User::getTelephoneNumber, User::setTelephoneNumber);
        binder.forField(address).bind(User::getAddress, User::setAddress);
        binder.forField(name).bind(User::getFirstName, User::setFirstName);
        binder.forField(lastname).bind(User::getLastName, User::setLastName);
        binder.forField(password).bind(User::getPasswod, User::setPassword);
        binder.forField(email).withValidator(new EmailValidator("Incorrect email address!")).bind(User::getEmail, User::setEmail);
        register.addClickListener(buttonClickEvent -> {
            if(password.getValue()=="" || email.getValue()==""){
                message.setValue("Email e Password richieste");
                return;
            }
            if (binder.validate().isOk()) {



                try {
                    userUtilsService.registerUser(binder.getBean());

                } catch (UserAlreadyExistException e) {
                    u=userUtilsService.getUserByEmail(email.getValue());
                    if (u.getPasswod()!=null){ message.setValue("Utente gia totalmente registrato"); }
                    else {
                        u.setAddress(address.getValue());
                        u.setFirstName(name.getValue());
                        u.setLastName(lastname.getValue());
                        u.setTelephoneNumber(telephone.getValue());
                        u.setPassword(password.getValue());
                        u = userUtilsService.updateUser(u);
                        message.setValue("Utente Registrato");
                    }
                }
                telephone.setValue("");
                address.setValue("");
                name.setValue("");
                lastname.setValue("");
                email.setValue("");
                password.setValue("");

            }else if(!binder.validate().isOk()) {
                message.setValue("Errore, Controlla i tuoi dati");
            }
        });

    }



    public Button accessCloseButton(){
        return closeButton;
    }

    public void setbutton(Button b) {
        userRegistration=b;
        userRegistration.addClickListener(buttonClickEvent -> {
            dialogRegitration.setWidth("800px");
            dialogRegitration.setHeight("500px");
            dialogRegitration.setDraggable(true);
            dialogRegitration.setResizable(true);
            dialogRegitration.setCloseOnOutsideClick(false);
            dialogRegitration.add(this);
            dialogRegitration.open();
        });

    }

    /**
     * This model binds properties between UserRegistration and user-registration
     */
    public interface UserRegistrationModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
