package com.qy.yms.test;
import java.awt.BorderLayout;

import javax.swing.*;

public class T
{
public static void main(String[] args)
{
try {
UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
} catch (Exception e) {
}

JTable table = new JTable(5, 5) {
public void removeEditor()
{
super.removeEditor();
repaint();
}
};

JComboBox combobox = new JComboBox() {
public void setBounds(int x, int y, int width, int height)
{
width = Math.max(getPreferredSize().width, width);
super.setBounds(x, y, width, height);
}
};
combobox.setBorder(BorderFactory.createEmptyBorder());
combobox.addItem("Hello World - 1");
combobox.addItem("Hello World - 2");
combobox.addItem("Hello World - 3");
DefaultCellEditor editor = new DefaultCellEditor(combobox);
table.setDefaultEditor(Object.class, editor);

JScrollPane sp = new JScrollPane(table);

JFrame frame = new JFrame();
frame.getContentPane().add(sp, BorderLayout.CENTER);
frame.pack();
frame.setLocationRelativeTo(null);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}
