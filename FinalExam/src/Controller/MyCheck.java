package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import View.ManagementGameView;

public class MyCheck {
	
	// Check game had
	public static boolean checkGame(String gameName, String studioName) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Game WHERE GameName = ? AND StudioName = ?;");
			ps.setString(1, gameName);
			ps.setString(2, studioName);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		}
		catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	// Chech user had
	public static boolean checkUser(String username) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM Information WHERE Username = ?;");;
			ps.setString(1, username);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		}
		catch (SQLException ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
		return false;
	}
	
	// Check Cart ITem user had
	public static boolean checkCartItemUserHad(int gameID, int userID) {
		
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM CartItem WHERE UserID = ? AND GameID = ?");
			ps.setInt(1, userID);
			ps.setInt(2, gameID);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}
	
	// Check Game User had
	public static boolean checkGameUserHad(int gameID, int userID) {
		try {
			Connection con = MyConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("SELECT * FROM UsersGame WHERE UserID = ? AND GameID = ?");
			ps.setInt(1, userID);
			ps.setInt(2, gameID);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
