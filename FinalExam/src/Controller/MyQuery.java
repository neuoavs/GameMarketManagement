package Controller;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import Model.MyTable;

import View.ManagementGameView;

public class MyQuery {


	public static String imagePath = "";
	
	public static void addGame(String gameName, String studioName, String gameGenre, int releaseYear, int gameCapacity, String gameDescription, float price, JLabel label, ImageIcon imageIcon) {
		InputStream img = null;
		InputStream notImg = null;
		try {
			notImg = new FileInputStream(new File("C:\\Users\\PHILONG\\Downloads\\Photo\\nothing.png"));
			img = new FileInputStream(MyConvert.convertImageIconToFile(imageIcon, "df.png"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		if (gameName.matches("") || studioName.matches("") || gameDescription.matches(""))
			JOptionPane.showConfirmDialog(null, "Check Your Enter Again");
		else if (MyCheck.checkGame(gameName, studioName))
			JOptionPane.showConfirmDialog(null, "The Game Name and the Studio Name have been used");
		else {
			try {
				Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("INSERT INTO Game (GameName, StudioName, Genre, ReleaseYear, GameCapacity, GameDescription, Image, Price) VALUES (?, ?, ?, ?, ?, ?, ?, ? );");
				ps.setString(1, gameName);
				ps.setString(2, studioName);
				ps.setString(3, gameGenre);
				ps.setInt(4, releaseYear);
				ps.setInt(5, gameCapacity);
				ps.setString(6, gameDescription);
				if (label.getIcon() == null)
					ps.setBlob(7, notImg);
				else
					ps.setBlob(7, img);
				ps.setFloat(8, price);
				if (ps.executeUpdate() != 0)
					JOptionPane.showConfirmDialog(null, "New Game Added");
				else
					JOptionPane.showConfirmDialog(null, "Something Error");
			} catch (SQLException ex) {
				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}

	public static void delGame(JTable table) {
		try {
			Connection con = MyConnection.getConnection();
			
			PreparedStatement ps = con.prepareStatement("DELETE FROM Game WHERE GameID = ?;");
			ps.setInt(1, (int) table.getValueAt(table.getSelectedRow(), 0));
			if (ps.executeUpdate() != 0)
				JOptionPane.showConfirmDialog(null, "Deleted");
			else
				JOptionPane.showConfirmDialog(null, "Something Error");
		} catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void updateGame(String gameName, String studioName, String gameNameEmpty, String studioNameEmpty, String gameGenre, int releaseYear, int gameCapacity, String gameDescription, float price, JLabel label, ImageIcon imageIcon, JTable table) {
		InputStream img = null;
		InputStream notImg = null;
		try {
			notImg = new FileInputStream(new File("C:\\Users\\PHILONG\\Downloads\\Photo\\nothing.png"));
			img = new FileInputStream(MyConvert.convertImageIconToFile(imageIcon, "df.png"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (gameName.matches("") || studioName.matches("") || gameDescription.matches(""))
			JOptionPane.showConfirmDialog(null, "Check Your Enter Again");
		else {
			try {
				Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE Game SET GameName = ?, StudioName = ?, Genre = ?, ReleaseYear = ?, GameCapacity = ?, GameDescription = ?, Image = ?, Price = ?  WHERE GameID = ?;");
				if (!gameName.matches(gameNameEmpty) && !studioName.matches(studioNameEmpty)) {
					if (MyCheck.checkGame(gameName, studioName))
						JOptionPane.showConfirmDialog(null, "This game already exists");
					else {
						ps.setString(1, gameName);
						ps.setString(2, studioName);
					}
						
				}
				else {
					ps.setString(1, gameName);
					ps.setString(2, studioName);
				}
				ps.setString(3, gameGenre);
				ps.setInt(4, releaseYear);
				ps.setInt(5, gameCapacity);
				ps.setString(6, gameDescription);
				if (label.getIcon() == null)
					ps.setBlob(7, notImg);
				else
					ps.setBlob(7, img);
				ps.setFloat(8, price);
				ps.setInt(9, (int) table.getValueAt(table.getSelectedRow(), 0));
				if (ps.executeUpdate() != 0)
					JOptionPane.showConfirmDialog(null, "Updated");
				else
					JOptionPane.showConfirmDialog(null, "Something Error");
			} 
			catch (SQLException ex) {
				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public static void findGame(JTable table, String gameName, String studioName) {
		if (gameName.matches("") && studioName.matches(""))
			JOptionPane.showConfirmDialog(null, "Check Your Enter Again");
		else {
			if (gameName.matches("")) {
				MyTable.getTable(table, "SELECT * FROM Game WHERE StudioName = '" + studioName + "';");
			}
			if (studioName.matches("")) {
				
				MyTable.getTable(table, "SELECT * FROM Game WHERE GameName = '" + gameName + "';");
			}
		}
	}
	
	public static void showGame(JTable table) {
		MyTable.getTable(table, "SELECT * FROM Game;");
	}
	
	public static void addUser(String username, String password, String email, String country, String gender, String money) {
		boolean b1 = email.matches("");
		boolean b2 = country.matches("");
		boolean b3 = gender.matches("");
		boolean b4 = money.matches("");
		if (username.matches("") || password.matches(""))
			JOptionPane.showConfirmDialog(null, "ERROR: Username or Password is null");
		else if (MyCheck.checkUser(username))
			JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
		else {
			try {
				Connection con = MyConnection.getConnection();
				PreparedStatement ps = null;
				if (b1 && !b2 && !b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', ?, ?, ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setString(4, gender);
					ps.setFloat(5, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && b2 && !b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, '', ?, ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, gender);
					ps.setFloat(5, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && !b2 && b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, ?, '', ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setFloat(5, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && !b2 && !b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, ?, ?, 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setString(5, gender);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && b2 && !b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', '', ?, ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, gender);
					ps.setFloat(4, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && b2 && b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, '', '', ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setFloat(4, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && !b2 && b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, ?, '', 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && !b2 && !b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', ?, ?, 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setString(4, gender);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && !b2 && b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', ?, '', ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setFloat(4, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && b2 && !b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, '', ?, 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, gender);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && b2 && b3 && !b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', '', '', ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setFloat(3, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && b2 && b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, '', '', 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && !b2 && b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', ?, '', 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && b2 && !b3 && b4) {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', '', ?, 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, gender);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (b1 && b2 && b3 && b4){
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, '', '', '', 0);");
					ps.setString(1, username);
					ps.setString(2, password);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else {
					ps = con.prepareStatement("INSERT INTO Information (Username, Password, Email, Country, Gender, Money) VALUES (?, ?, ?, ?, ?, ?);");
					ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setString(5, gender);
					ps.setFloat(6, Float.parseFloat(money));
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Added");
					else 
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				
			} catch (SQLException ex) {
				JOptionPane.showConfirmDialog(null, "Something Error");
				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	
	
	public static void delUser(JTable table) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("DELETE FROM Information WHERE UserID = ?");
			ps.setInt(1, (int) table.getValueAt(table.getSelectedRow(), 0));
			if (ps.executeUpdate() != 0)
				JOptionPane.showConfirmDialog(null, "Deleted");
			else
				JOptionPane.showConfirmDialog(null, "Something Error");
		} catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	public static void updateUser(String username, String usernameEmpty, String password, String email, String country, String gender, String money, JTable table) {
		
		int userID = (int) table.getValueAt(table.getSelectedRow(), 0);
		
		boolean b1 = email.matches("");
		boolean b2 = country.matches("");
		boolean b3 = gender.matches("");
		boolean b4 = money.matches("");
		
		if (username.matches("") || password.matches(""))
			JOptionPane.showConfirmDialog(null, "ERROR: Username or Password is null");
		else {
			try {
				Connection con = MyConnection.getConnection();
				PreparedStatement ps = null;
				if (b1 && !b2 && !b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = ?, Gender = ?, Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setString(4, gender);
					ps.setFloat(5, Float.parseFloat(money));
					ps.setInt(6, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
					else
						JOptionPane.showConfirmDialog(null, "Something Error");
				}
				else if (!b1 && b2 && !b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = '', Gender = ?, Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, gender);
					ps.setFloat(5, Float.parseFloat(money));
					ps.setInt(6, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && !b2 && b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = ?, Gender = '', Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setFloat(5, Float.parseFloat(money));
					ps.setInt(6, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && !b2 && !b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = ?, Gender = ?, Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setString(5, gender);
					ps.setInt(6, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && b2 && !b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = '', Gender = ?, Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, gender);
					ps.setFloat(4, Float.parseFloat(money));
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && b2 && b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = '', Gender = '', Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setFloat(4, Float.parseFloat(money));
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && !b2 && b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = ?, Gender = '', Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && !b2 && !b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = ?, Gender = ?, Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setString(4, gender);
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && !b2 && b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = ?, Gender = '', Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setFloat(4, Float.parseFloat(money));
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && b2 && !b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = '', Gender = ?, Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, gender);
					ps.setInt(5, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && b2 && b3 && !b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = '', Gender = '', Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setFloat(3, Float.parseFloat(money));
					ps.setInt(4, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (!b1 && b2 && b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = '', Gender = '', Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setInt(4, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && !b2 && b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = ?, Gender = '', Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, country);
					ps.setInt(4, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && b2 && !b3 && b4) {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = '', Country = '', Gender = ?, Money = 0 WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, gender);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else if (b1 && b2 && b3 && b4){
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = ?, Gender = ?, Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				else {
					ps = con.prepareStatement("UPDATE Information SET Username = ?, Password = ?, Email = ?, Country = ?, Gender = ?, Money = ? WHERE UserID = ?;");
					
					if (!username.matches(usernameEmpty)) {
						if (MyCheck.checkUser(username))
							JOptionPane.showConfirmDialog(null, "ERROR: This username already exists");
						else
							ps.setString(1, username);
					}
					else
						ps.setString(1, username);
					ps.setString(2, password);
					ps.setString(3, email);
					ps.setString(4, country);
					ps.setString(5, gender);
					ps.setFloat(6, Float.parseFloat(money));
					ps.setInt(7, userID);
					if (ps.executeUpdate() != 0)
						JOptionPane.showConfirmDialog(null, "Updated");
				}
				
			} catch (SQLException ex) {
				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	public static void findUser(String username, String email, String gender, String country, JTable table) {
		
		boolean b1 = username.matches("");
		boolean b2 = email.matches("");
		boolean b3 = gender.matches("");
		boolean b4 = country.matches("");

		if (!b1 && b2 && b3 && b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Username = '" + username + "';");
		}
		if (b1 && !b2 && b3 && b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Email = '" + email + "';");
		}
		if (b1 && b2 && !b3 && b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Gender = '" + gender + "';");
		}
		if (b1 && b2 && b3 && !b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Country = '" + country + "';");
		}
		if (b1 && !b2 && !b3 && b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Email = '" + email + "' AND Gender = '" + gender + "';");
		}
		if (b1 && b2 && !b3 && !b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Gender = '" + gender + "' AND Country = '" + country + "';");
		}
		if (b1 && !b2 && b3 && !b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Email = '" + email + "' AND Country = '" + country + "';");
		}
		if (b1 && !b2 && !b3 && !b4) {
			MyTable.getTable(table, "SELECT * FROM Information WHERE Email = '" + email + "' AND Gender = '" + gender + "' AND Country = '" + country + "';");
		}
	}
	
	public static void showUser(JTable table) {
		
		MyTable.getTable(table, "SELECT * FROM Information;");
	}
	
	public static void filterGame(String fromYear, String toYear, String largerCap, String smallerCap, String genreGame, JTable table) {
		
		boolean b1 = fromYear.matches("");
		boolean b2 = toYear.matches("");
		boolean b3 = largerCap.matches("");
		boolean b4 = smallerCap.matches("");
		boolean b5 = genreGame.matches("");
		
		if (!b1 && b2 && b3 && b4 && b5) {
			
			int num = Integer.parseInt(fromYear);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num +";");
		}
		else if (b1 && !b2 && b3 && b4 && b5) {
			
			int num = Integer.parseInt(toYear);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num + ";");
		}
		else if (b1 && b2 && !b3 && b4 && b5) {
			
			float num = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity >= " + num * 1024 + ";");
		}
		else if (b1 && b2 && b3 && !b4 && b5) {
			
			float num = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity <= " + num * 1024 + ";");
		}
		else if (b1 && b2 && b3 && b4 && !b5) {
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE Genre = '" + genreGame + "';");
		}
		// 2 Check
		else if (!b1 && !b2 && b3 && b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + ";");
			}
		}
		else if (b1 && !b2 && !b3 && b4 && b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(largerCap);

			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity >= " + num2 * 1024 + ";");
		}
		else if (b1 && b2 && !b3 && !b4 && b5) {
			
			float num1 = Float.parseFloat(largerCap);
			float num2 = Float.parseFloat(smallerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity >= " + num1 * 1024 + " AND GameCapacity <= " + num2 * 1024 + ";");
			}
		}
		else if (b1 && b2 && b3 && !b4 && !b5) {
		
			float num = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity <= " + num * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && b3 && b4 && !b5) {
			
			int num = Integer.parseInt(fromYear);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && !b3 && b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity >= " + num2 * 1024 + ";");
		}
		else if (b1 && !b2 && b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity <= " + num2 * 1024 + ";");
		}
		else if (b1 && b2 && !b3 && b4 && !b5) {
			
			float num = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity >= " + num * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity <= " + num2 * 1024 + ";");
		}
		else if (b1 && !b2 && b3 && b4 && !b5) {
			
			int num = Integer.parseInt(toYear);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num + " AND Genre = '" + genreGame + "';");
		}
		// 3 check
		else if (!b1 && !b2 && !b3 && b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			float num3 = Float.parseFloat(largerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND GameCapacity >= " + num3 * 1024 + ";");
			}
		}
		else if (b1 && !b2 && !b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(largerCap);
			float num3 = Float.parseFloat(smallerCap);
			
			if (num2 > num3)
				JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity >= " + num2 * 1024 + " AND GameCapacity <= " + num3 * 1024 + ";");
			}
		}
		else if (b1 && b2 && !b3 && !b4 && !b5) {
			
			float num1 = Float.parseFloat(largerCap);
			float num2 = Float.parseFloat(smallerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE GameCapacity >= " + num1 * 1024 + " AND GameCapacity <= " + num2 * 1024 + " AND Genre = '" + genreGame + "';");
			}
		}
		else if (!b1 && b2 && b3 && !b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity <= " + num2 * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && !b2 && b3 && b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND Genre = '" + genreGame + "';");
			}
		}
		else if (!b1 && !b2 && b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			float num3 = Float.parseFloat(smallerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND GameCapacity <= " + num3 * 1024 + ";");
			}
		}
		else if (b1 && !b2 && !b3 && b4 && !b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity >= " + num2 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && !b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(largerCap);
			float num3 = Float.parseFloat(smallerCap);
			
			if (num2 > num3)
				JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity >= " + num2 * 1024 + " AND GameCapacity <= " + num3 * 1024 + ";");
			}
		}
		else if (b1 && !b2 && b3 && !b4 && !b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity <= " + num2 * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && !b3 && b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(largerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity >= " + num2 * 1024 + " AND Genre = '" + genreGame + "';");
		}
		// 4 Check - 5
		else if (!b1 && !b2 && !b3 && !b4 && b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			float num3 = Float.parseFloat(largerCap);
			float num4 = Float.parseFloat(smallerCap);
			
			if (num1 > num2) {
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
				if (num3 > num4)
					JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			}
			else if (num3 > num4)
				JOptionPane.showConfirmDialog(null, "The 'Larger' cannot be less than the 'Smaller'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND GameCapacity >= " + num3 * 1024 + " AND GameCapacity <= " + num4 * 1024 + ";");
			}	
		}
		else if (b1 && !b2 && !b3 && !b4 && !b5) {
			
			int num1 = Integer.parseInt(toYear);
			float num2 = Float.parseFloat(largerCap);
			float num3 = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear <= " + num1 + " AND GameCapacity >= " + num2 * 1024 + " AND GameCapacity <= " + num3 * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && b2 && !b3 && !b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			float num2 = Float.parseFloat(largerCap);
			float num3 = Float.parseFloat(smallerCap);
			
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND GameCapacity >= " + num2 * 1024 + " AND GameCapacity <= " + num3 * 1024 + " AND Genre = '" + genreGame + "';");
		}
		else if (!b1 && !b2 && b3 && !b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			float num3 = Float.parseFloat(smallerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND GameCapacity <= " + num3 * 1024 + " AND Genre = '" + genreGame + "';");
			}
		}
		else if (!b1 && !b2 && !b3 && b4 && !b5) {
			
			int num1 = Integer.parseInt(fromYear);
			int num2 = Integer.parseInt(toYear);
			float num3 = Float.parseFloat(largerCap);
			
			if (num1 > num2)
				JOptionPane.showConfirmDialog(null, "The 'From Year' cannot be less than the 'To Year'");
			else {
				MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game WHERE ReleaseYear >= " + num1 + " AND ReleaseYear <= " + num2 + " AND GameCapacity >= " + num3 * 1024 + " AND Genre = '" + genreGame + "';");
			}
		}
		else {
			MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game;");
		}
	}
	
	// Show Table Cart
	public static void showTableCart(JTable table, int userID) {
		MyTable.getTable(table, "SELECT GameName, StudioName, Genre, Price FROM (CartItem INNER JOIN Game ON CartItem.GameID = Game.GameID) WHERE UserID = " + userID + ";");
	}
	
	// Remove games of Cart
	public static void removeTableCart(JTable table, JLabel label) {
		
		int[] rowIndex = table.getSelectedRows();
		
		try {
			for (int row : rowIndex) {
				String gameName = table.getValueAt(row, 0).toString();
				String studioname = table.getValueAt(row, 1).toString();
				int gameID = getIDGame(gameName, studioname);
				int userID = getIDUser(label);
				Connection con = MyConnection.getConnection();;
				PreparedStatement ps = con.prepareStatement("DELETE FROM CartItem WHERE UserID = ? AND GameID = ?;");
				ps.setInt(1, userID);
				ps.setInt(2, gameID);
				ps.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// Update data Personal
	public static void updateData(JTextField nameTextField, JTextField emailTextField, JComboBox genderComboBox, JComboBox countryComboBox, JLabel label) {
		String name = nameTextField.getText();
		String email = emailTextField.getText();
		String gender = genderComboBox.getSelectedItem().toString();
		String country = countryComboBox.getSelectedItem().toString();
		int ID = getIDUser(label);
			
		if (name.matches("") || email.matches("") || gender.matches("") || country.matches(""))
			JOptionPane.showConfirmDialog(null, "Check Your Enter Again");
		else {
			try {
				Connection con = MyConnection.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE Information SET Username = ?, Email = ?, Country = ?, Gender = ? WHERE UserID = ?;");
				ps.setString(1, name);
				ps.setString(2, email);
				ps.setString(3, country);
				ps.setString(4, gender);
				ps.setInt(5, ID);
				if (ps.executeUpdate() != 0)
					JOptionPane.showConfirmDialog(null, "Updated");
				else
					JOptionPane.showConfirmDialog(null, "Something Error");
			} catch (SQLException ex) {
				Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
	// Get money of user
	public static float getMoney(int userID) {
		float money = 0f;
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT Money FROM Information WHERE UserID = ?;");
			ps.setInt(1, userID);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				money = rs.getFloat("Money");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	
	// Get ID of user
	public static int getIDUser(JLabel label) {
		
		String username = label.getText();
		
		int id = 0;
		
		int index = username.indexOf(' ');
		
		if (index != -1)
			username = username.substring(0, index);
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT UserID FROM Information WHERE Username = ?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				id = rs.getInt("UserID");
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
		return id;
	}
	
	// Ger ID Game
	public static int getIDGame(String gameName, String studioName) {
		int id = 0;
			
		Connection con = MyConnection.getConnection();
		try {
			PreparedStatement ps = con.prepareStatement("SELECT GameID FROM Game WHERE GameName = ? AND StudioName = ?;");
			ps.setString(1, gameName);
			ps.setString(2, studioName);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				id = rs.getInt("GameID");
		} catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
			return id;
	}
	
	//Show data of Home Game
	public static void showHomeTable(JTable table) {	
		MyTable.getTable(table, "SELECT GameName, StudioName, Genre, ReleaseYear, Price FROM Game;");
	}
	
	//Show Data of your game
	public static void showYourGameTable(JTable table, JLabel label){
		int userID = getIDUser(label);
		
		MyTable.getTable(table, "SELECT GameName, StudioName FROM UsersGame INNER JOIN Game ON UsersGame.GameID = Game.GameID WHERE UserID = " + userID + ";");
		
	}
	
	// set personal of user
	public static void setPer(JTextField nameTextField, JTextField emailTextField, JComboBox genderComboBox, JComboBox countryComboBox, JLabel label) {
		
		String username = label.getText();
		
		int index = username.indexOf(' ');
		
		if (index != -1)
			username = username.substring(0, index);
		
		
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT Email, Country, Gender FROM Information WHERE Username = ?;");
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				nameTextField.setText(username);
				emailTextField.setText(rs.getString("Email"));
				genderComboBox.setSelectedItem(rs.getString("Gender"));
				countryComboBox.setSelectedItem(rs.getString("Country"));
			}
		} catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
