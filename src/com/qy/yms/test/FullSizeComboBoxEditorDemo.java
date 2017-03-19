package com.qy.yms.test;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

import com.sun.java.swing.plaf.windows.WindowsComboBoxUI;

public class FullSizeComboBoxEditorDemo {
public static void main(String[] args) {
try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (Exception e) {
}
JComboBox combobox = new JComboBox() {
public void updateUI() {
setUI(new MyComboBoxUI());
}
};
combobox.addItem("The quick brown fox jumps over the lazy dog.");
combobox.addItem("The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.");
combobox.addItem("The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.");

JFrame frame = new JFrame();
((JComponent) frame.getContentPane()).setBorder(
BorderFactory.createEmptyBorder(10, 10, 10, 10));
frame.getContentPane().add(combobox, BorderLayout.NORTH);
frame.pack();
frame.setSize(100, frame.getHeight());
frame.validate();
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}


