
import javax.swing.JFrame;
import java.awt.Canvas;
import java.awt.Dimension;

public class Display {

	private JFrame frame; // other classees shouldn have to use this
	// JFrames need a title, a width, and a height

	private Canvas canvas; // allows us to draw graphics

	private String title;
	private int width, height; // in pixels

	public Display(String title, int width, int height){
		// This will initalize out variables
		this.title = title;
		this.width = width;
		this.height = height;

		createDisplay();
	}
	public void createDisplay(){
		frame = new JFrame(title);
		frame.setSize(width, height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setMaximumSize(new Dimension(width, height));
		canvas.setMinimumSize(new Dimension(width, height));
		canvas.setFocusable(false);

		frame.add(canvas);
		frame.pack();
	}

	
	public Canvas getCanvas(){
		return canvas;
		// this is a getter for the canvas object, this makes it so we do not have to make the canvas itself public
	}

	public JFrame getFrame(){
		return frame;
	}
}