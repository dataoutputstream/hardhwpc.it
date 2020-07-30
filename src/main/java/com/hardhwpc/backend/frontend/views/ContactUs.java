package com.hardhwpc.backend.frontend.views;

import com.hardhwpc.backend.entities.Message;
import com.hardhwpc.backend.services.MessageService;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.validator.EmailValidator;
import com.vaadin.flow.templatemodel.TemplateModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.messaging.MessageSecurityMetadataSourceRegistry;

/**
 * A Designer generated component for the contact-us template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("contact-us")
@JsModule("./src/views/contact-us.js")
public class ContactUs extends PolymerTemplate<ContactUs.ContactUsModel> {
    Binder<Message> bindermessage;
    @Id("name")
    private TextField name;
    @Id("email")
    private TextField email;
    @Id("phone_number")
    private TextField phone_number;
    @Id("messageText")
    private TextArea messageText;
    @Id("messageHeader")
    private TextField messageHeader;
    @Id("sendButton")
    private Button sendButton;
    @Id("result")
    private TextField result;
    MessageService messageService;
    Message message;
    @Id("orderNumber")
    private TextField orderNumber;

    /**
     * Creates a new ContactUs.
     */
    @Autowired
    public ContactUs(MessageService messageService) {
        this.messageService=messageService;
        bindermessage=new Binder<Message>();
        bindermessage.setBean(new Message());
        bindermessage.forField(name).withValidator(name -> name.length() >= 1, "Inserisci un nominativo").bind(Message::getName,Message::setName);
        bindermessage.forField(email).withValidator(new EmailValidator("Email malformata")).bind(Message::getEmail,Message::setEmail);
        bindermessage.forField(phone_number).bind(Message::getPhone_number,Message::setPhone_number);
        bindermessage.forField(messageText).withValidator(messageText -> messageText.length()>=1,"Inserisci il messaggio").bind(Message::getMessage,Message::setMessage);
        bindermessage.forField(messageHeader).withValidator(messageHeader->messageHeader.length()>=1,"Almeno un carattere").bind(Message::getHeader,Message::setHeader);
        bindermessage.forField(orderNumber).bind(Message::getOrdernumber,Message::setOrdernumber);
        sendButton.addClickListener(buttonClickEvent -> {
            if(bindermessage.validate().isOk()){
                message=messageService.save(bindermessage.getBean());
            }
            if(message!=null){
                result.setValue("Messaggio Inviato");
                name.setValue("");
                email.setValue("");
                phone_number.setValue("");
                messageText.setValue("");
                messageHeader.setValue("");
                orderNumber.setValue("");
            }else{
                result.setValue("Impossbile inviare il messaggio momentaneamente");
            }
        });

    }

    /**
     * This model binds properties between ContactUs and contact-us
     */
    public interface ContactUsModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
