package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.polymertemplate.Id;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.StreamResource;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * A Designer generated component for the admin-page template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("admin-page")
@JsModule("./src/views/admin-page.js")
@Route("adminPage")
public class AdminPage extends PolymerTemplate<AdminPage.AdminPageModel> {

    @Id("logoContainer")
    private HorizontalLayout logoContainer;
    File file = new File("frontend/resources/logo.png");
    private Image logo_store;
    @Id("adminsOrderView")
    private AdminsOrderview adminsOrderView;
    @Id("adminsUserview")
    private AdminsUserview adminsUserview;
    @Id("adminsContact")
    private AdminsContact adminsContact;

    /**
     * Creates a new AdminPage.
     */
    public AdminPage() {
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

    }

    /**
     * This model binds properties between AdminPage and admin-page
     */
    public interface AdminPageModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
