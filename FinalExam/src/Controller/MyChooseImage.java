package Controller;

import java.awt.Image;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;

// Add picture from System
public class MyChooseImage {
	
	public static ImageIcon resizePic(String picPath, int w, int h) {
		ImageIcon ic = new ImageIcon(picPath);
		Image ig = ic.getImage().getScaledInstance(w, h, Image.SCALE_SMOOTH);
		ImageIcon imC = new ImageIcon(ig);
		return imC;
	}
	
	public static String chooseImage(JLabel label) {
		String path = "";
		
		JFileChooser file = new JFileChooser();
		file.setCurrentDirectory(new File("user.dir"));
		
		FileNameExtensionFilter filter = new FileNameExtensionFilter("All pic", "png", "jpg", "jpeg", "gif");
		file.addChoosableFileFilter(filter);
		
		int fs = file.showSaveDialog(null);
		
		if (fs == JFileChooser.APPROVE_OPTION) {
			File fi = file.getSelectedFile();
			path = fi.getAbsolutePath();
			
			label.setIcon(resizePic(path, label.getWidth(), label.getHeight()));
		}
		return path;
	}
}
