package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.entities.User;
import com.hardhwpc.backend.services.OrderService;
import com.hardhwpc.backend.services.UserUtilsService;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
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

/**
 * A Designer generated component for the admins-userview template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-userview")
@JsModule("./src/views/admins-userview.js")
public class AdminsUserview extends PolymerTemplate<AdminsUserview.AdminsUserviewModel> {
    UserUtilsService userUtilsService;
    @Id("ordertype")
    private ComboBox<String> ordertype;
    List<String> ordertypeitems=new ArrayList<String>();
    List<String> orderboxitems=new ArrayList<String>();
    @Id("orderbox")
    private ComboBox<String> orderbox;
    @Id("ordersGrid")
    private Grid<User> userGrid;
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
     * Creates a new AdminsUserview.
     */
    @Autowired
    public AdminsUserview(UserUtilsService userUtilsService,OrderService orderService) {
        this.userUtilsService=userUtilsService;
        initcomboboxs();
        userGrid.addColumn(User::getId).setHeader("Id");
        userGrid.addColumn(User::getLastName).setHeader("Last Name");
        userGrid.addColumn(User::getFirstName).setHeader("Name");
        userGrid.addColumn(User::getEmail).setHeader("Email");
        userGrid.addColumn(User::getTelephoneNumber).setHeader("Phone");
        userGrid.addSelectionListener(selectionEvent -> {
            AdminsUserdetails adminsOrderdetails=new AdminsUserdetails(orderService,userUtilsService);
            adminsOrderdetails.load(userGrid.getSelectedItems());
            adminsOrderdetails.setPointer(this);
            this.getUI().ifPresent(ui -> {
                ui.removeAll();
                ui.add(adminsOrderdetails);
            });

        });
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
    }

    public void restoreView(){
        UI.getCurrent().getPage().reload();

    }


    @PostConstruct
    private void popola() {
        List<User> ordini=composer();
        if(nomorecontent)return;
        userGrid.setItems(ordini);

    }

    private List<User> composer() {
        List<User>utenti=new ArrayList<>();
        if(!havetorefinetheresearch) {
            if (orderbox.getValue() == "Cognome" && ordertype.getValue() == "Crescente") {
                utenti = userUtilsService.showAllUsers(currentpage, pagesize, "lastName", "ascending");
            } else if (orderbox.getValue() == "Cognome" && ordertype.getValue() == "Decrescente") {
                utenti = userUtilsService.showAllUsers(currentpage, pagesize, "lastName", "descending");
            } else if (ordertype.getValue() == "Crescente") {
                utenti = userUtilsService.showAllUsers(currentpage, pagesize, "email", "ascending");
            } else {
                utenti = userUtilsService.showAllUsers(currentpage, pagesize, "email", "descending");
            }
            if (utenti.size() == 0){ nomorecontent = true;}else{ nomorecontent = false;}
        }else if(havetorefinetheresearch){
           List<User> u;
            u=userUtilsService.getUsersByEmail(filter.getValue());
            if(u.size()==0){
                u=userUtilsService.getUsersByName(filter.getValue());
            }
        }
        return utenti;
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
        orderboxitems.add("Cognome");
        orderboxitems.add("Email");
        orderbox.setItems(orderboxitems);
        orderbox.setValue("Cognome");
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
     * This model binds properties between AdminsUserview and admins-userview
     */
    public interface AdminsUserviewModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
