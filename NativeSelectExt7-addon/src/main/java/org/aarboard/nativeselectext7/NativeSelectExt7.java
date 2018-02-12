package org.aarboard.nativeselectext7;

import com.vaadin.v7.ui.NativeSelect;
import org.aarboard.nativeselectext7.client.NativeSelectExt7State;

// This is the server-side UI component that provides public API 
// for NativeSelectExt7
public class NativeSelectExt7 extends NativeSelect  {


    public void setItemDisabled(Object itemId, boolean disabled) {
        boolean modified= false;
        NativeSelectExt7State state= getState();
        String indexStr= itemIdMapper.key(itemId);
        if (state.disabledIndizes.contains(indexStr))
        {
            // Found, need to remove?
            if (!disabled)
            {
                state.disabledIndizes.remove(indexStr);
                modified= true;
            }
        }
        else
        {
            // Found, need to remove?
            if (disabled)
            {
                state.disabledIndizes.add(indexStr);
                modified= true;
            }
        }
        if (modified)
        {
            getState(true);
        }
    }

    @Override
    protected NativeSelectExt7State getState() {
        return (NativeSelectExt7State)super.getState(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected NativeSelectExt7State getState(boolean markAsDirty) {
        return (NativeSelectExt7State)super.getState(markAsDirty); //To change body of generated methods, choose Tools | Templates.
    }
}
