
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;


public class TheAssets {

	private static BufferedImage img;
	private static final int width = 100, height = 100;
	public static BufferedImage one, two, three;

	public static void init(){

		try {
		    img = ImageIO.read(new File("Darcy.gif"));
		} catch (IOException e) {
			
		}
		Spreadsheet sheet = new Spreadsheet(img);
		one = sheet.crop(0,0,width, height);
		two = sheet.crop(50,50,width, height);
		three = sheet.crop(50,100, width, height);
	}
}