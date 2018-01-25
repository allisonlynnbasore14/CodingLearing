
import java.awt.Color;
import java.awt.Graphics;

public class SettingState extends State{

	public SettingState(Handler handler){
		super(handler);
	}

	public void tick(){

	}

	public void render(Graphics g){
		g.setColor(Color.blue);
		g.fillRect(10,20,40,100); // x,y,width, height
	}

}