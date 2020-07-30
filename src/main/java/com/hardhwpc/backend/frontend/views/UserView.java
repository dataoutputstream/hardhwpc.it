package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Message;
import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.frontend.main.MainView;
import com.hardhwpc.backend.services.MessageService;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.support.exceptions.UserNotFoundException;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the user-view template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("user-view")
@JsModule("./src/views/user-view.js")
public class UserView extends PolymerTemplate<UserView.UserViewModel> {


    MessageService messageService;
    LoginUser loginUser;

    User u;
    @Id("exitButton")
    private Button exitButton;
    @Id("messageText")
    private TextArea messageText;
    @Id("messageButton")
    private Button messageButton;
    @Id("ordersGrid")
    private Grid<Order> ordersGrid;

    OrderService orderService;
    @Id("welcomeText")
    private TextField welcomeText;
    @Id("orderBox")
    private ComboBox<String> orderBox;
    @Id("messageTitle")
    private TextField messageTitle;
    List<String> orderBoxItems;
    Binder<Message> messageBinder;
    Message message;
    @Id("result")
    private TextField result;


    /**
     * Creates a new UserView.
     */
    @Autowired
    public UserView(OrderService orderService, MessageService messageService) {
        this.orderService=orderService;
        this.messageService=messageService;
        loaduserdata();
        orderBoxItems=new ArrayList<>();
        messageBinder=new Binder<>();
        message=new Message();
        messageBinder.setBean(message);
        messageBinder.forField(orderBox).bind(Message::getOrdernumber,Message::setOrdernumber);
        messageBinder.forField(messageTitle).withValidator(messageTitle->messageTitle.length()>=1,"One Character at least required").bind(Message::getHeader,Message::setHeader);
        messageBinder.forField(messageText).withValidator(messageText->messageText.length()>=1,"Message Text Required").bind(Message::getMessage,Message::setMessage);
    }

    @PostConstruct
    private void loaduserdata() {

        ordersGrid.addColumn(Order::getId).setHeader("OrderID");
        ordersGrid.addColumn(Order::getOrdernumber).setHeader("Order Number");
        ordersGrid.addColumn(Order::getShippingnumber).setHeader("Shipping Number");
        ordersGrid.addColumn(Order::getOrderstate).setHeader("Order State");
        ordersGrid.addColumn(Order::getPurchaseTime).setHeader("Purchase Time");
        ordersGrid.addItemClickListener(selectionEvent -> {
            OrderDialog orderDialog= new OrderDialog(selectionEvent.getItem());
        });
        exitButton.addClickListener(buttonClickEvent -> {
           this.getUI().ifPresent(ui -> {
               ui.removeAll();
               ui.navigate(MainView.class);
           });
        });
        messageButton.addClickListener(buttonClickEvent -> {
            if(messageBinder.validate().isOk()){
                message=messageBinder.getBean();
                message.setName(u.getLastName()+" "+ u.getFirstName());
                message.setEmail(u.getEmail());
                message.setPhone_number(u.getTelephoneNumber());
                messageService.save(message);
                this.messageText.setValue("");
                this.messageTitle.setValue("");
                result.setValue("Messaggio Inviato");
            }

        });

    }

    public void setUser(User getUser) {
        u=getUser;
        try {
            List<Order>orders=orderService.getOrderByUser(u);
            ordersGrid.setItems(orders);
            for (Order order:orders) {
                orderBoxItems.add(order.getOrdernumber());
            }
            orderBox.setItems(orderBoxItems);
            orderBox.setValue(orderBoxItems.get(0));
            welcomeText.setValue(" Benvenuto "+u.getFirstName().toString());
        } catch (UserNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * This model binds properties between UserView and user-view
     */
    public interface UserViewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
