

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

public class ImageLoader{
	
	public static BufferedImage loadImage(){
		System.out.println("MADE IT TO IMAGE LOADER");
		BufferedImage img = null;
		try {
		    return img = ImageIO.read(new File("beautiful-cross.jpg"));
		} catch (IOException e) {
			return null;
		}
	}
}