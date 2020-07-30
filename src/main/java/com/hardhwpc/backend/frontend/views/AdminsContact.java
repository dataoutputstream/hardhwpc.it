package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Message;
import com.hardhwpc.backend.entities.Order;
import com.hardhwpc.backend.services.MessageService;
import com.hardhwpc.backend.services.SmtpMailSender;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * A Designer generated component for the admins-contact template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-contact")
@JsModule("./src/views/admins-contact.js")
public class AdminsContact extends PolymerTemplate<AdminsContact.AdminsContactModel> {

    @Id("messagesGrid")
    private Grid<Message> messagesGrid;
    @Id("scrivi")
    private Button scrivi;
    @Id("messageCounter")
    private TextField messageCounter;
    MessageService messageService;
    SmtpMailSender smtpMailSender;
    int pagesize=13;
    int currentpage=0;
    @Id("forwardbutton")
    private Button forwardbutton;
    boolean nomorecontent=false;
    boolean havetorefinetheresearch=false;
    @Id("backbutton")
    private Button backbutton;


    /**
     * Creates a new AdminsContact.
     */
    @Autowired
    public AdminsContact(MessageService messageService,SmtpMailSender smtpMailSender) {
        this.messageService=messageService;
        this.smtpMailSender=smtpMailSender;
        messagesGrid.addColumn(Message::getEmail).setHeader("Email");
        messagesGrid.addColumn(Message::getHeader).setHeader("Head");
        messagesGrid.addColumn(Message::getPhone_number).setHeader("Phone");
        messagesGrid.addColumn(Message::getMessage).setHeader("Message");
        messagesGrid.setPageSize(pagesize);
        messagesGrid.addSelectionListener(selectionEvent -> {
            Dialog messageDialog= new Dialog();
            AdminsMessagedialog adminsMessagedialog=new AdminsMessagedialog();
            adminsMessagedialog.setMessage((Message)messagesGrid.getSelectedItems().toArray()[0]);
            adminsMessagedialog.setMessageService(smtpMailSender);
            messageDialog.add(adminsMessagedialog);
            messageDialog.setSizeFull();
            messageDialog.setSizeUndefined();
            messageDialog.open();
        });
        scrivi.addClickListener(buttonClickEvent -> {
            Dialog messageDialog= new Dialog();
            AdminsNewmessage adminsNewmessage=new AdminsNewmessage();
            adminsNewmessage.setMessageService(smtpMailSender);
            messageDialog.add(adminsNewmessage);
            messageDialog.setHeight("700px");
            messageDialog.setWidth("1000px");
            messageDialog.open();

        });
        messageCounter.setValue(messageService.count());
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


    }

    @PostConstruct
    private void popola() {
        List<Message> ordini=composer();
        if(nomorecontent)return;
        messagesGrid.setItems(ordini);
    }

    private List<Message> composer() {
        List<Message>messaggi=new ArrayList<>();
        if(!havetorefinetheresearch) {
            messaggi = messageService.showAllMessages(currentpage, pagesize, "messageTime", "descending");
            if (messaggi.size() == 0){ nomorecontent = true;}else{ nomorecontent = false;}
        }else if(havetorefinetheresearch){
            //
        }
        return messaggi;
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


    /**
     * This model binds properties between AdminsContact and admins-contact
     */
    public interface AdminsContactModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
