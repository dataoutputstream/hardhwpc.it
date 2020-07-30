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
 * A Designer generated component for the admins-newmessage template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admins-newmessage")
@JsModule("./src/views/admins-newmessage.js")
public class AdminsNewmessage extends PolymerTemplate<AdminsNewmessage.AdminsNewmessageModel> {

    @Id("email")
    private TextField email;
    @Id("ourMessage")
    private TextArea ourMessage;
    @Id("title")
    private TextField title;
    private SmtpMailSender smtpMailSender;
    @Id("result")
    private TextField result;
    @Id("sendButton")
    private Button sendButton;


    /**
     * Creates a new AdminsNewmessage.
     */
    public AdminsNewmessage() {
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


    public void setMessageService(SmtpMailSender smtpMailSender) {
        this.smtpMailSender=smtpMailSender;
    }

    /**
     * This model binds properties between AdminsNewmessage and admins-newmessage
     */
    public interface AdminsNewmessageModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
