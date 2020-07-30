package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.BillingData;
import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.frontend.main.MainView;
import com.hardhwpc.backend.services.BillingService;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.ProductService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.hardhwpc.backend.support.exceptions.UserAlreadyExistException;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * A Designer generated component for the complete-order template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("complete-order")
@JsModule("./src/views/complete-order.js")
public class CompleteOrder extends PolymerTemplate<CompleteOrder.CompleteOrderModel> {

    @Id("nomesped")
    private TextField shipname;
    @Id("addresship")
    private TextArea addresship;
    @Id("pivaship")
    private TextField pivaship;
    @Id("invoiceform")
    private FormLayout invoiceform;
    @Id("fatturazioneDiversa")
    private Checkbox fatturazioneDiversa;
    @Id("invname")
    private TextField invname;
    @Id("invfisccode")
    private TextField invfisccode;
    @Id("invpiva")
    private TextField invpiva;
    @Id("infoorder")
    private TextArea infoorder;
    @Id("paytype")
    private ComboBox<String> paytype;
    @Id("orderButton")
    private Button orderButton;
    @Id("telship")
    private TextField telship;
    @Id("emailship")
    private TextField emailship;
    @Id("result")
    private TextArea result;
    @Id("invuid")
    private TextField invuid;
    @Id("email")
    private TextField email;
    @Id("shiplastname")
    private TextField shiplastname;
    MainView puntatoreMainView;
    User u;
    List<Product>cart;
    @Id("backbutton")
    private Button backbutton;
    @Id("password")
    private TextField password;
    OrderController orderController;
    Binder<User> binder = new Binder<>(User.class);
    Binder<BillingData> binderfd = new Binder<>(BillingData.class);



    /**
     * Creates a new CompleteOrder.
     */
    public CompleteOrder() {

        binder.setBean(new User());
        binder.forField(pivaship).bind(User::getCode, User::setCode);
        binder.forField(shipname).bind(User::getFirstName, User::setFirstName);
        binder.forField(shiplastname).bind(User::getLastName, User::setLastName);
        binder.forField(telship).bind(User::getTelephoneNumber, User::setTelephoneNumber);
        binder.forField(addresship).bind(User::getAddress, User::setAddress);
        binder.forField(password).bind(User::getPasswod, User::setPassword);
        binder.forField(emailship).withValidator(new EmailValidator("Incorrect email address!")).bind(User::getEmail, User::setEmail);
        orderButton.addClickListener(buttonClickEvent -> {
                    if (binder.validate().isOk()) {
                        User checkUser=binder.getBean();
                        checkUser.setPassword(new BCryptPasswordEncoder().encode(checkUser.getPasswod()));
                        try {
                            u=orderController.registerUser(binder.getBean());

                        } catch (UserAlreadyExistException e) {
                            if(orderController.matchPassword(checkUser)) {
                                result.setValue("Utente Fedele");
                                u = orderController.getUserByEmail(emailship.getValue());
                                u.setAddress(addresship.getValue());
                                u.setFirstName(shipname.getValue());
                                u.setLastName(shiplastname.getValue());
                                u.setTelephoneNumber(telship.getValue());
                                u = orderController.updateUser(u);
                            }else{
                                result.setValue("Password Errata!");
                                return;
                            }
                        }
                        emailship.setValue("");
                        addresship.setValue("");
                        telship.setValue("");
                        shipname.setValue("");
                        shiplastname.setValue("");
                        password.setValue("");
                        pivaship.setValue("");
                        result.setValue("Done!");
                    }else if(!binder.validate().isOk()){
                        result.setValue("Errore, Controlla i tuoi dati");

                    }if(fatturazioneDiversa.getValue()){
                        if(binderfd.validate().isOk()){
                            BillingData bd=binderfd.getBean();
                            bd.setUser(u);
                            BillingData bduser=orderController.getBillingDataForUser(u);
                            if(bduser!=null){
                                bd.setId(bduser.getId());
                            }
                            orderController.addBillingData(bd);
                            u.setFiscaladdress(bd);
                            orderController.updateUser(u);
                        }else if(!binderfd.validate().isOk()) {
                            result.setValue("Errore, Controlla i tuoi dati");
                        }
                        email.setValue("");
                        invfisccode.setValue("");
                        invname.setValue("");
                        invpiva.setValue("");
                        invuid.setValue("");
                        result.setValue("Done!");
                    }

                    Order ordine=new Order();
                    ordine.setBuyer(u);
                    ordine.setOrderstate("Accettato");
                    Double totalprice = 0.0;
                     for (Product p:cart) {
                        totalprice+=p.getPrice();
                    }
                     ordine.setTotalprice(String.valueOf(totalprice));
                    ordine.setProductsInOrder(cart);
                    Order o=orderController.addOrder(ordine);
                    if(o==null){
                        result.setValue("Qualche prodotto nel carrello non è più disponibili");
                    }else{
                        result.setValue("Ordine Completato");
                    }

        });
        fatturazioneDiversa.addValueChangeListener(checkboxBooleanComponentValueChangeEvent -> {
            if(fatturazioneDiversa.getValue()==true){
                binderfd.setBean(new BillingData());
                binderfd.forField(invpiva).bind(BillingData::getPiva, BillingData::setPiva);
                binderfd.forField(invname).withValidator(name -> name.length() >= 1, "Inserisci un nominativo").bind(BillingData::getBillingName, BillingData::setBillingName);
                binderfd.forField(email).withValidator(new EmailValidator("Email malformata")).bind(BillingData::getEmailpec,BillingData::setEmailpec);
                binderfd.forField(invfisccode).bind(BillingData::getCf,BillingData::setCf);
                binderfd.forField(invuid).bind(BillingData::getuCode, BillingData::setuCode);

                invuid.setEnabled(true);
                invpiva.setEnabled(true);
                invname.setEnabled(true);
                invfisccode.setEnabled(true);
                email.setEnabled(true);

            }else{
                invuid.setEnabled(false);
                invpiva.setEnabled(false);
                invname.setEnabled(false);
                invfisccode.setEnabled(false);
                email.setEnabled(false);

            }
        });
        fatturazioneDiversa.setValue(true);
        paytype.setItems("Contrassegno","Paypal");
        paytype.setValue("Contrassegno");

        backbutton.addClickListener(buttonClickEvent -> {
            this.getUI().ifPresent(ui -> {
               ui.getUI().ifPresent(ui1 -> {
                   ui.removeAll();
                   ui.add(puntatoreMainView);
               });
            });

        });
    }



    public void setMainView(MainView mainView) {
        this.puntatoreMainView=mainView;
    }

    public void setServices(OrderService orderService, UserUtilsService userUtilsService, BillingService billingService,ProductService productService) {
       orderController=new OrderController();
        orderController.setServices(orderService,userUtilsService,billingService,productService);
    }

    /**
     * This model binds properties between CompleteOrder and complete-order
     */
    public interface CompleteOrderModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }

    public void setProducts(List<Product>products){
        this.cart=products;
    }
}
