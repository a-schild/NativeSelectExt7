package org.aarboard.nativeselectext7;

import com.vaadin.data.Container;
import com.vaadin.ui.NativeSelect;
import java.util.Collection;
import org.aarboard.nativeselectext7.client.NativeSelectExt7State;

// This is the server-side UI component that provides public API 
// for NativeSelectExt7
public class NativeSelectExt7 extends NativeSelect  {

    /** 
     * Creates a new NativeSelectExt7 with an empty caption and no items.
     */
    public NativeSelectExt7()
    {
        super();
    }
        
    /** 
     * Creates a new NativeSelectExt7 with the given caption and no items.
     * @param caption field caption
     */
    public NativeSelectExt7(String caption)
    {
        super(caption);
    }
    
    /** 
     * Creates a new NativeSelectExt7 with the given caption,
     * containing the data items in the given collection.
     * @param caption field caption
     * @param items     Items to populate
     */
    public NativeSelectExt7(String caption, Collection<?> items)
    {
        super(caption, items);
    }
    
    /** 
     * Creates a new NativeSelectExt7 with the given caption, 
     * using the given DataProvider as the source of data items.
     * @param caption    field caption
     * @param dataSource    Data source for select
     */
    public NativeSelectExt7(String caption, Container dataSource)
    {
        super(caption, dataSource);
    }

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
