package com.hardhwpc.backend.frontend.views;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.templatemodel.TemplateModel;

/**
 * A Designer generated component for the sepolicy-site template.
 *
 * Designer will add and remove fields with @Id mappings but
 * does not overwrite or otherwise change this file.
 */
@Tag("sepolicy-site")
@JsModule("./src/views/sepolicy-site.js")
public class SepolicySite extends PolymerTemplate<SepolicySite.SepolicySiteModel> {

    /**
     * Creates a new SepolicySite.
     */
    public SepolicySite() {
        // You can initialise any data required for the connected UI components here.
    }

    /**
     * This model binds properties between SepolicySite and sepolicy-site
     */
    public interface SepolicySiteModel extends TemplateModel {
        // Add setters and getters for template properties here.
    }
}
