package Test;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;

import View.EnterAccountVIew;
import View.ManagementGameView;

public class MainTest {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new EnterAccountVIew();
		} catch (Exception ex) {
			Logger.getLogger(ManagementGameView.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
