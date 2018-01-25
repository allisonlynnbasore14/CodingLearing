
import java.awt.image.BufferedImage;

public class Spreadsheet{
	// This is made to cut up a big image into little images

	private BufferedImage sheet;

	public Spreadsheet(BufferedImage sheet){

		this.sheet = sheet;

	}

	public BufferedImage crop(int x, int y, int width, int height){
		return sheet.getSubimage( x , y , width , height );
	}
}