
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class UIImageButton extends UIObject {


	private BufferedImage[] images;
	private ClickListener clicker;

	public UIImageButton(float x, float y, int width, int height, ClickListener clicker){
		super(x,y,width,height);
		this.images = images;
		this.clicker = clicker;
	}

	public void tick() {

	}

	public void render(Graphics g){
		if(hovering){
			g.setColor(Color.white);
			g.fillRect((int) (x), (int) (y), width, height); // x,y,width, height
		// (int) this is called casting
			//g.drawImage(images[1], (int) x, (int)y, width, height, null)
		}else{
			g.setColor(Color.orange);
			g.fillRect((int) (x), (int) (y), width, height); 
		}	
	}

	public void onClick() {
		clicker.onClick();
	}



}