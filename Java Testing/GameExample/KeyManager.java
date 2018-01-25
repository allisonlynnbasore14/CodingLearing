

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class KeyManager implements KeyListener{


	private boolean[] keys;
	public boolean up, down, left, right;
	public boolean aUp, aDown, aLeft, aRight;

	public KeyManager(){
		keys = new boolean[256];
	}

	public void tick(){
		up = keys[KeyEvent.VK_W];
		down = keys[KeyEvent.VK_S];
		left = keys[KeyEvent.VK_A];
		right = keys[KeyEvent.VK_D];

		aUp = keys[KeyEvent.VK_UP];
		aDown = keys[KeyEvent.VK_DOWN];
		aLeft = keys[KeyEvent.VK_LEFT];
		aRight = keys[KeyEvent.VK_RIGHT];
	}

	public void keyPressed(KeyEvent e){
				System.out.println("HERE JACK!!!!");
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e){
		keys[e.getKeyCode()] = false;
		
	}

	public void keyTyped(KeyEvent e){
		
	}

}