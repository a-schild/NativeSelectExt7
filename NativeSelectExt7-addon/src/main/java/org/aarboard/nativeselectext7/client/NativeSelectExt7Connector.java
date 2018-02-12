package org.aarboard.nativeselectext7.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.NodeList;
import com.google.gwt.dom.client.OptionElement;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.UIDL;
import org.aarboard.nativeselectext7.NativeSelectExt7;

import com.vaadin.shared.ui.Connect;
import com.vaadin.client.ui.VNativeSelect;
import com.vaadin.client.ui.nativeselect.NativeSelectConnector;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

// Connector binds client-side widget class to server-side component class
// Connector lives in the client and the @Connect annotation specifies the
// corresponding server-side component
@Connect(NativeSelectExt7.class)
public class NativeSelectExt7Connector extends NativeSelectConnector {


    public void updateDisabledState() {
        getLogger().log(Level.SEVERE, "updateDisabledState NativeSelectExt7Connector");

        Widget widget= getWidget();
        if (widget != null)
        {
            List<String> disabled= getState().disabledIndizes;
            VNativeSelect ns = (VNativeSelect) widget;
            ListBox list = ns.getSelect();
            NodeList<Element> nl= list.getElement().getElementsByTagName("option");
            for(int i=0 ; i < nl.getLength(); i++)
            {
                OptionElement e = (OptionElement)nl.getItem(i);
                String v= e.getValue();
                if (disabled.contains(v))
                {
                    e.setDisabled(true);
                    getLogger().log(Level.SEVERE, "dumpWidget NativeSelectExt7Connector element found to disabled "+v);
                }
            }
        }
    }


    @Override
    public NativeSelectExt7State getState() {
        return (NativeSelectExt7State) super.getState(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateFromUIDL(UIDL uidl, ApplicationConnection client) {
        getLogger().log(Level.SEVERE, "updateFromUILD NativeSelectExt7Connector started");
        dumpWidget();
        super.updateFromUIDL(uidl, client); //To change body of generated methods, choose Tools | Templates.
        getLogger().log(Level.SEVERE, "updateFromUILD NativeSelectExt7Connector finished");
        dumpWidget();
        updateDisabledState();
        getLogger().log(Level.SEVERE, "updateFromUILD NativeSelectExt7Connector after updateDisabledState");
        dumpWidget();
    }

    protected void dumpWidget()
    {
        Widget widget= getWidget();
        if (widget != null)
        {
            VNativeSelect ns = (VNativeSelect) widget;
            ListBox list = ns.getSelect();
            NodeList<Element> nl= list.getElement().getElementsByTagName("option");
            for (int i= 0; i < nl.getLength(); i++)
            {
                OptionElement e = (OptionElement)nl.getItem(i);
                getLogger().log(Level.SEVERE, "dumpWidget NativeSelectExt7Connector element found "+i+" "+e.isDisabled());
            }
        }
    }
    
    private static Logger getLogger() {
        return Logger.getLogger(NativeSelectExt7Connector.class.getName());
    }
}
