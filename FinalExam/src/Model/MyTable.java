package Model;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

// insert Data from database to JTable
public class MyTable extends AbstractTableModel {
	
    private Vector<Vector<Object>> data;
    private Vector<String> columnNames;

    public MyTable(ResultSet rs) {
        initData(rs);
    }

    public void initData(ResultSet rs) {
        data = new Vector<>();
        columnNames = new Vector<>();

        try {
            java.sql.ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Get column names
            for (int column = 1; column <= columnCount; column++) {
                columnNames.add(metaData.getColumnName(column));
            }

            // Get data
            while (rs.next()) {
                Vector<Object> rowData = new Vector<>();
                for (int column = 1; column <= columnCount; column++) {
                    if ("Image".equals(columnNames.get(column - 1))) {
                        // Convert byte to Image
                        byte[] imageBytes = rs.getBytes("Image");
                        ImageIcon imageIcon = new ImageIcon(imageBytes);
                        rowData.add(imageIcon);
                    } else {
                        rowData.add(rs.getObject(column));
                    }
                }
                data.add(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }
}