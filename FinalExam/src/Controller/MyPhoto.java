package Controller;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//Show Image from Database (BLOB) to JTable
public class MyPhoto extends JLabel implements TableCellRenderer {

    public MyPhoto() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
        if (value instanceof ImageIcon) {
            setIcon((ImageIcon) value);
        } else {
            setIcon(null);
        }
        return this;
    }

}
