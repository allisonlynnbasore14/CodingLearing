import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

//import dev..tilegame.display.Display;

public class Game implements Runnable{

	private Display display;

	private int width, height;

	private static BufferedImage img;
	private static final int widthImg = 200, heightImg = 100;
	public static BufferedImage one, two, three;



	public String title;

	// A thread: a mini program that runs seperate the larger program
	// lets you run a class seperatly


	public Thread thread;

	private Spreadsheet sheet;

	public State gameState;
	public State menuState;
	public State settingState;

	//private Assets asset;

	private BufferedImage testImage;

	private boolean running = false;

	private BufferStrategy bs;

	private KeyManager keyManager;
	private MouseManager mouseManager;



	// Camera
	private GameCamera gameCamera;

	private Handler handler;

	private Graphics g;

	public Game(String title, int width, int height){
		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
		mouseManager = new MouseManager();
	}

	private void init(){
		// initalize graphics
		handler = new Handler(this);

		display = new Display(title, width, height);

		display.getFrame().addKeyListener(keyManager);
		display.getFrame().addMouseListener(mouseManager);
		display.getFrame().addMouseMotionListener(mouseManager);
		display.getCanvas().addMouseListener(mouseManager);
		display.getCanvas().addMouseMotionListener(mouseManager);

		gameCamera = new GameCamera(handler,0,0);



		try {
		    img = ImageIO.read(new File("Darcy.gif"));
		} catch (IOException e) {
			
		}

		System.out.println(img);
		Spreadsheet sheet = new Spreadsheet(img);
		one = sheet.crop(0,0,widthImg, heightImg);
		two = sheet.crop(100,100,widthImg, heightImg);
		three = sheet.crop(100,200, widthImg, heightImg);

		gameState = new GameState(handler);

		menuState = new MenuState(handler);
		settingState = new SettingState(handler);
		
		State.setState(menuState);
		//testImage = ImageLoader.loadImage();
		// try {
		//     testImage = ImageIO.read(new File("Darcy.gif"));
		// } catch (IOException e) {
			
		// }

		// sheet = new Spreadsheet(testImage);ImageIO.read(new File("Darcy.gif"))

	}

	private void tick(){
		keyManager.tick();
		
		if(State.getState() != null){
			State.getState().tick();
		}
		
	}

	private void render(){
		//TheAssets.init();
		bs = display.getCanvas().getBufferStrategy();
		// a buffer strategy: how to tell the computer to draw, a buffer is a hidden computer screen inside your computer
		// without this it would glitch like old games did
		if(bs == null){
			display.getCanvas().createBufferStrategy(2); // is the max you shoudl go
			return;
		}

		g = bs.getDrawGraphics();
		// the graphic object is like the paintbrush

		// Draw here!!!!
		g.clearRect(0,0,width,height);
		// must be callled before anything is drawn

		if(State.getState() != null){
			State.getState().render(g);
		}

		//Tile.tiles[0].render(g, 0,0);

		//g.drawImage(one, x, 5, null);
		//g.drawImage(two, 200, 100, null);
		//g.drawImage(three, 5, 200, null);

		//RECTANGELS
		// g.setColor(Color.red);
		// g.fillRect(10,20,40,100); // x,y,width, height

		// g.setColor(Color.blue);
		//g.fillRect(30,100,40,100);


		// The cordinate system ins java starts in top left, and the y axis increases as you are going down

		// g.fillRect( 0, 0,  width, height); // x, y, width, height

		bs.show();
		g.dispose();
	}

	public void run(){
		// this is requried with runnable
		init();

		int fps = 60;
		double timePerTic = 1000000000/ fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while(running){
			now = System.nanoTime();
			delta += (now-lastTime)/timePerTic;
			timer += (now - lastTime);
			lastTime = now;

			if(delta >= 1){
				tick();
				render();
				ticks ++;
				delta--;
			}

			if(timer >= 1000000000){
				// System.out.println("Ticks " + ticks);
				ticks = 0;
				timer = 0;
			}

		}

		stop();

	}

	public KeyManager getKeyManager(){
		return keyManager;
	}

	public MouseManager getMouseManager(){
		return mouseManager;
	}

	public GameCamera getGameCamera(){
		return gameCamera;
	}

	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}

	public synchronized void start(){
		
		if (running)
			return;
		running = true;
		// sychronized is used when working with threads directly
		thread = new Thread(this); // takes in the game you want to run
		thread.start();
	}

	public synchronized void stop(){
		if (!running)
			return;
		running = false;
		try{
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
