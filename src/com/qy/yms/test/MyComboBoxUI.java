package com.qy.yms.test;

import javax.swing.plaf.basic.ComboPopup;

import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;

public class MyComboBoxUI extends WindowsComboBoxUI {
protected ComboPopup createPopup() {
return new MyComboBoxPopup(comboBox);
}
}
