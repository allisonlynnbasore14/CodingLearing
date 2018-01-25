
import java.util.ArrayList;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Rectangle;


public abstract class UIObject{


	protected float x,y;
	protected int width, height;


	public UIObject (float x, float y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle((int) x, (int) y , width, height);
	}


	public abstract void tick();

	public abstract void render(Graphics g);
	protected Rectangle bounds;
	public abstract void onClick();
	protected boolean hovering = false;

	public void onMouseMove(MouseEvent e){
		// A button is in this method and we checkc if the mouse is on this button
		if(bounds.contains(e.getX(), e.getY())){
			hovering = true;
		}else{
			hovering = false;
		}
	}

	public void onMouseRelease(MouseEvent e){
		if(hovering){
			onClick();
			// this is built in method
		}
	}


	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isHovering() {
		return hovering;
	}

	public void setHovering(boolean hovering) {
		this.hovering = hovering;
	}


}