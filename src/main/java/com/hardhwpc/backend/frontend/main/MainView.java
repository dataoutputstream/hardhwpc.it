package com.hardhwpc.backend.frontend.main;

import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.frontend.views.*;
import com.hardhwpc.backend.services.BillingService;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.ProductService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Viewport;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.PreserveOnRefresh;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;


/**
 * A Designer generated component for the main-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("main-view")
@JsModule("./src/views/main-view.js")
@Route("mainView")
@PreserveOnRefresh
@Viewport("width=device-width, minimum-scale=1, initial-scale=1, user-scalable=yes, viewport-fit=cover")
public class MainView<ThemeResource> extends PolymerTemplate<MainView.MainViewModel> {


    @Id("userbutton")
    private Button userbutton;
    @Id("vaadinVerticalLayout")
    private VerticalLayout vaadinVerticalLayout;
    @Id("userTab")
    private Tab userTab;
    @Id("cartbutton")
    private Button cartbutton;
    @Id("allProducts")
    private AllProducts allProducts;
    @Id("nogetticarello")
    private TextField nogetticarello;
    @Id("totalecarrello")
    private TextField totalecarrello;
    @Id("filter")
    private TextField filter;
    OrderService orderService;
    UserUtilsService userUtilsService;
    BillingService billingService;
    ProductService productService;
    Cart cart;
    CompleteOrder orderMaker;
    File file = new File("frontend/resources/logo.png");
    private Image logo_store;
    @Id("logoContainer")
    private HorizontalLayout logoContainer;
    @Id("contactUs")
    private ContactUs contactUs;
    @Id("guarantee")
    private StoreGuarantee guarantee;
    @Id("sepolicySite")
    private SepolicySite sepolicySite;


    /**
     * Creates a new MainView.
     */
    @Autowired
    public  MainView(OrderService orderService,UserUtilsService userUtilsService,BillingService billingService,ProductService productService) {
            /**
            userbutton.addClickListener(buttonClickEvent ->{

              userbutton.getUI().ifPresent(ui -> ui.navigate(LoginUser.class));
            });
            **/
             Image image = new Image(new StreamResource("logo.png", () -> {
                 try {
                      return new FileInputStream(file);
                 } catch (FileNotFoundException e) {
                     // file not found
                    e.printStackTrace();
                 }
                 return null;
            }), "alt text");
             logo_store=image;
             logo_store.setWidth("300px");
             logo_store.setMaxHeight("180px");
             logoContainer.removeAll();
             logoContainer.add(logo_store);
            this.userUtilsService=userUtilsService;
            this.orderService=orderService;
            this.billingService=billingService;
            this.productService=productService;
            cart=new Cart();
            cart.setRef(this);
            cart.setTotTextVew(totalecarrello);
            cart.setNoggetti(nogetticarello);
            userbutton.addClickListener(buttonClickEvent -> {
                this.getUI().ifPresent(ui -> ui.navigate(LoginUser.class));
            });
            cart.setCartbutton(cartbutton);
            allProducts.setRef(this);
            allProducts.manageReseach(filter);

    }

    public void aggiungiProdotto(Product p, int value) {
        cart.aggiungi(p,value);
    }

    public void ordina(ArrayList<Product> carrello) {
        orderMaker=new CompleteOrder();
        orderMaker.setProducts(carrello);
        orderMaker.setMainView(this);
        orderMaker.setServices(orderService,userUtilsService,billingService,productService);
        this.getUI().ifPresent(ui -> {
            ui.removeAll();
            ui.add(orderMaker);
        });

    }


    /**
     * This model binds properties between MainView and main-view
     */
    public interface MainViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
