package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.MessageService;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.PostConstruct;


/**
 * A Designer generated component for the login-user template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("login-user")
@Route("users")
@JsModule("./src/views/login-user.js")
public class LoginUser extends PolymerTemplate<LoginUser.LoginUserModel> {


    public User getUser;
    @Id("registerButton")
    private Button registerButton;
    @Id("vaadinLoginForm")
    private LoginForm vaadinLoginForm;
    UserView userView;

    UserUtilsService userUtilsService;
    OrderService orderService;
    MessageService messageService;


    private UserRegistration userRegistration;

    Button userbutton;
    @Id("messageField")
    private TextField messageField;
    private String user;
    private String password;

    /**
     * Creates a new LoginUser.
     */
    @Autowired
    public LoginUser(UserUtilsService userUtilsService, OrderService orderService, MessageService messageService) {
        this.userUtilsService=userUtilsService;
        this.orderService=orderService;
        this.messageService=messageService;
        vaadinLoginForm.setForgotPasswordButtonVisible(false);
        vaadinLoginForm.setEnabled(true);
        vaadinLoginForm.addLoginListener(loginEvent -> {
            user=loginEvent.getUsername().toString();
            password=loginEvent.getPassword().toString();
            String passwordencoded = new BCryptPasswordEncoder().encode(password);
            if(!userUtilsService.containsUserByEmail(user)){
                messageField.setValue("Non sei registrato");
                vaadinLoginForm.setEnabled(true);
                registerButton.click();
            }else{
                getUser= userUtilsService.getLogInIfDatasMatches(user,passwordencoded);
                if(getUser!=null){
                    userView=new UserView(orderService,messageService);
                    userView.setUser(getUser);
                    this.getUI().ifPresent(ui -> {
                        ui.removeAll();
                        ui.add(userView);
                    });
                }else{
                    messageField.setValue("Credenziali errate");
                    vaadinLoginForm.setEnabled(true);
                }
            }
        });

        userRegistration=new UserRegistration(userUtilsService);
        userRegistration.setbutton(registerButton);
    }

    public void setUserbutton(Button b){
        this.userbutton=b;

        userbutton.addClickListener(buttonClickEvent -> {
            Dialog dialog = new Dialog(this);
            dialog.setDraggable(true);
            dialog.setSizeUndefined();
            dialog.setWidth("335px");
            dialog.setHeight("550px");
            dialog.add(this);
            dialog.setCloseOnOutsideClick(false);
            dialog.setCloseOnEsc(false);
            dialog.open();
        });


    }

    public User getUser() {
        return  getUser;
    }

    /**
     * This model binds properties between LoginUser and login-user
     */
    public interface LoginUserModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
