package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.entities.Product;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.OrderService;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.page.Page;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * A Designer generated component for the admins-orderview template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-orderview")
@JsModule("./src/views/admins-orderview.js")
public class AdminsOrderview extends PolymerTemplate<AdminsOrderview.AdminsOrderviewModel> {
    OrderService orderService;
    @Id("ordertype")
    private ComboBox<String> ordertype;
    List<String> ordertypeitems=new ArrayList<String>();
    List<String> orderboxitems=new ArrayList<String>();
    @Id("orderbox")
    private ComboBox<String> orderbox;
    @Id("ordersGrid")
    private Grid<Order> ordersGrid;
    final static int pagesize=12;
    int currentpage=0;
    @Id("forwardbutton")
    private Button forwardbutton;
    @Id("backbutton")
    private Button backbutton;
    boolean nomorecontent=false;
    private Boolean havetorefinetheresearch=false;
    @Id("filter")
    private TextField filter;


    /**
     * Creates a new AdminsOrderview.
     */
    @Autowired
    public AdminsOrderview(OrderService orderService) {
        this.orderService=orderService;
        initcomboboxs();
        ordersGrid.addColumn(Order::getId).setHeader("Id");
        ordersGrid.addColumn(Order::getOrdernumber).setHeader("Order Number");
        ordersGrid.addColumn(Order::getOrderstate).setHeader("State");
        ordersGrid.addColumn(Order::getShippingnumber).setHeader("Ship-Number");
        ordersGrid.addColumn(Order::getTotalprice).setHeader("Total");
        ordersGrid.addColumn(( Order::getBuyer)).setHeader("Buyer");
        ordersGrid.addColumn(Order::getPurchaseTime).setHeader("OrderDate");
        backbutton.addClickListener(buttonClickEvent -> {
            if(currentpage==0)return;
            previouspage();
            popola();
        });
        forwardbutton.addClickListener(buttonClickEvent -> {
            nextpage();
            popola();
            if(nomorecontent){currentpage--;return;}

        });
        ordertype.addValueChangeListener(comboBoxStringComponentValueChangeEvent -> {
            popola();
        });
        orderbox.addValueChangeListener(comboBoxStringComponentValueChangeEvent ->{
            popola();
        });
        manageReseach();
        ordersGrid.setSelectionMode(Grid.SelectionMode.SINGLE);
        ordersGrid.addSelectionListener(selectionEvent -> {
                AdminsOrderdetails adminsOrderdetails=new AdminsOrderdetails(orderService);
                adminsOrderdetails.load(ordersGrid.getSelectedItems());
                adminsOrderdetails.setPointer(this);
                this.getUI().ifPresent(ui -> {
                    ui.removeAll();
                    ui.add(adminsOrderdetails);
                });

        });

    }


    public void restoreView(){
        UI.getCurrent().getPage().reload();

    }

    @PostConstruct
    private void popola() {
        List<Order>ordini=composer();
        if(nomorecontent)return;
        ordersGrid.setItems(ordini);
    }

    private List<Order> composer() {
        List<Order>ordini=new ArrayList<>();
        if(!havetorefinetheresearch) {
            if (orderbox.getValue() == "Data" && ordertype.getValue() == "Crescente") {
                ordini = orderService.showAllOrders(currentpage, pagesize, "purchaseTime", "ascending");
            } else if (orderbox.getValue() == "Data" && ordertype.getValue() == "Decrescente") {
                ordini = orderService.showAllOrders(currentpage, pagesize, "purchaseTime", "descending");
            } else if (ordertype.getValue() == "Crescente") {
                ordini = orderService.showAllOrders(currentpage, pagesize, "totalprice", "ascending");
            } else {
                ordini = orderService.showAllOrders(currentpage, pagesize, "totalprice", "descending");
            }
            if (ordini.size() == 0){ nomorecontent = true;}else{ nomorecontent = false;}
        }else if(havetorefinetheresearch){
            ordini=orderService.showOrderByOrderNumber(filter.getValue());
            if(ordini.size()==0){
                ordini=orderService.showOrdersByShippingNumber(filter.getValue());
            }
        }
        return ordini;
    }

    private int nextpage() {
        currentpage++;
        return  currentpage;
    }
    private int previouspage(){
        if(currentpage==0)return 0;
        currentpage--;
        return currentpage;
    }

    private void initcomboboxs(){

        ordertypeitems.add("Crescente");
        ordertypeitems.add("Decrescente");
        ordertype.setItems(ordertypeitems);
        ordertype.setValue("Decrescente");
        orderboxitems.add("Data");
        orderboxitems.add("Prezzo");
        orderbox.setItems(orderboxitems);
        orderbox.setValue("Data");
    }
    public void manageReseach() {
        filter.addValueChangeListener(textFieldStringComponentValueChangeEvent -> {
            if(!filter.getValue().isEmpty()){
                havetorefinetheresearch=true;
            }else{
                havetorefinetheresearch=false;
            }
            popola();
        });
    }

    /**
     * This model binds properties between AdminsOrderview and admins-orderview
     */
    public interface AdminsOrderviewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
