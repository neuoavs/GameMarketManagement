package Controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

// Set background and forgetground of JTable Header
public class MyHeaderColor extends DefaultTableCellRenderer {
    public MyHeaderColor(Font font) {
        setHorizontalAlignment(JLabel.CENTER);
        setOpaque(true);
        setFont(font);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
                                                   boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        setBackground(new Color(3, 6, 9));
        setForeground(new Color(62, 124, 185));
        setText(value != null ? value.toString() : "");
        return this;
    }
}

