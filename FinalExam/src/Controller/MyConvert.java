package Controller;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MyConvert {
	
	// Convert Image Icon to File
	public static File convertImageIconToFile(ImageIcon imageIcon, String outputFileName) throws IOException {

        Image image = imageIcon.getImage();


        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        bufferedImage.getGraphics().drawImage(image, 0, 0, null);


        File outputFile = new File(outputFileName);


        ImageIO.write(bufferedImage, "png", outputFile);

        return outputFile;
    }
	
}
