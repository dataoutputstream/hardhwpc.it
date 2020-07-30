package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Message;
import com.hardhwpc.backend.services.SmtpMailSender;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import javax.mail.MessagingException;

/**
 * A Designer generated component for the admins-messagedialog template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-messagedialog")
@JsModule("./src/views/admins-messagedialog.js")
public class AdminsMessagedialog extends PolymerTemplate<AdminsMessagedialog.AdminsMessagedialogModel> {

    @Id("messageText")
    private TextArea messageText;
    @Id("email")
    private TextField email;
    @Id("sendButton")
    private Button sendButton;
    @Id("ourMessage")
    private TextArea ourMessage;
    @Id("title")
    private TextField title;
    private SmtpMailSender smtpMailSender;
    private Message message;
    @Id("userName")
    private TextField userName;
    @Id("phoneNumber")
    private TextField phoneNumber;
    @Id("result")
    private TextField result;

    /**
     * Creates a new AdminsMessagedialog.
     */
    public AdminsMessagedialog() {
        sendButton.addClickListener(buttonClickEvent -> {
            if(!ourMessage.isEmpty()){
                try {
                    smtpMailSender.send(email.getValue(),title.getValue(),ourMessage.getValue());
                } catch (MessagingException e) {
                    e.printStackTrace();
                    result.setValue("Messaggio non inviato!");
                    return;
                }
                result.setValue("Messaggio Inviato");
                ourMessage.setValue("");
            }
        });
    }

    public void setMessage(Message message) {
        this.message=message;
        messageText.setValue(message.getMessage());
        email.setValue(message.getEmail());
        userName.setValue(message.getName());
        phoneNumber.setValue(message.getPhone_number());
        title.setValue("HardHwPcStore " + message.getHeader());
    }

    public void setMessageService(SmtpMailSender smtpMailSender) {
        this.smtpMailSender=smtpMailSender;
    }

    /**
     * This model binds properties between AdminsMessagedialog and admins-messagedialog
     */
    public interface AdminsMessagedialogModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
