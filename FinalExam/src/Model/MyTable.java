package Model;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import Controller.MyConnection;
import Controller.MyHeaderColor;
import Controller.MyPhoto;

// insert Data from database to JTable
public class MyTable{
	
	public static void getTable(JTable table, String sql) {
		//sql: SELECT only
		DefaultTableModel model = new DefaultTableModel();
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData rsmeta = rs.getMetaData();
			int colCount = rsmeta.getColumnCount();
			// Add col name
			for (int i = 1; i <= colCount; i++) {
				model.addColumn(rsmeta.getColumnName(i));
			}
			int indexImg = 0;
			// Add row
			while(rs.next()) {
				Object[] rows = new Object[colCount]; 
				for (int i = 0; i < colCount; i++) {
					if (rsmeta.getColumnName(i + 1).matches("Image")) {
						indexImg = i;
						byte[] imgB = rs.getBytes("Image");
						ImageIcon img = new ImageIcon(imgB);
					    rows[i] = img;
					} else {
						rows[i] = rs.getObject(i + 1);
					}
				}
				model.addRow(rows);
			}
			
			table.setModel(model);
			// Show image (If Having)
			if (indexImg != 0) {
				table.getColumnModel().getColumn(indexImg).setCellRenderer(new MyPhoto());
				table.getColumnModel().getColumn(indexImg).setPreferredWidth(70);
			}
			table.setRowHeight(40);
			
			JTableHeader tableHeader = table.getTableHeader();
	        tableHeader.setDefaultRenderer(new MyHeaderColor(new Font("Agency FB", Font.BOLD, 26)));
			table.setBackground(new Color(200, 218, 236));
			table.setForeground(new Color(27, 55, 82));
			table.setFont(new Font("Agency FB", Font.BOLD, 21));
			con.close();
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
