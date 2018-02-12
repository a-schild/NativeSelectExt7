package org.aarboard.nativeselectext7.demo;

import org.aarboard.nativeselectext7.NativeSelectExt7;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import java.util.Arrays;

@Theme("demo")
@Title("NativeSelectExt7 Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI
{
    private Boolean status= true;

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        String items[]= {"Item 1", "Item 2", "Item 3", "Item 4"};
        // Initialize our new UI component
        final NativeSelectExt7 component = new NativeSelectExt7();
        
        component.addItems(Arrays.asList(items));
        // Show it in the middle of the screen
        final VerticalLayout layout = new VerticalLayout();
        layout.setStyleName("demoContentLayout");
        layout.setSizeFull();
        layout.setMargin(false);
        layout.setSpacing(false);
        layout.addComponent(component);
        layout.setComponentAlignment(component, Alignment.MIDDLE_CENTER);
        setContent(layout);
        component.setItemDisabled("Item 4", status);
        layout.addComponent(new Label("Vaadin 7 based"));
        Button b= new Button("Toggle 'Item 1'");
        layout.addComponent(b);
        b.addClickListener((event) -> {
            component.setItemDisabled("Item 1", status);
            b.setCaption("Item 1 "+(status ? "disabled" : "enabled"));
            status= !status;
        });
    }
}
