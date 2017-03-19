package com.qy.yms.test;

import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.plaf.basic.BasicComboPopup;

class MyComboBoxPopup extends BasicComboPopup {
public MyComboBoxPopup(JComboBox combo) {
super(combo);
}

    protected JScrollPane createScroller() {
        JScrollPane sp = new JScrollPane( list, 
ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,
ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED );
        return sp;
    }

    public void show() {
        setListSelection(comboBox.getSelectedIndex());

Insets insets = getInsets();
int popupPrefWid = list.getPreferredSize().width + insets.left + insets.right;

Dimension scrollSize = new Dimension(
comboBox.getWidth(), getPopupHeightForRowCount( comboBox.getMaximumRowCount()));
if (popupPrefWid > scrollSize.width) {
scrollSize.height += scroller.getHorizontalScrollBar().getPreferredSize().height;
}
    
scroller.setMaximumSize( scrollSize );
scroller.setPreferredSize( scrollSize );
scroller.setMinimumSize( scrollSize );
list.revalidate();

show( comboBox, 0, comboBox.getHeight());
    }
    
    private void setListSelection(int selectedIndex) {
        if ( selectedIndex == -1 ) {
            list.clearSelection();
        }
        else {
            list.setSelectedIndex( selectedIndex );
            list.ensureIndexIsVisible( selectedIndex );
        }
    }
}
