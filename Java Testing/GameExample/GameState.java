
import java.awt.Color;
import java.awt.Graphics;

// javac *.java 

public class GameState extends State{


	private World world;


	public GameState(Handler handler){
		super(handler);
		world = new World(handler, "res/Worlds/world1.txt");
		handler.setWorld(world);
		// player = new Player(Color.red,0,0, handler); // starting position
		// player2 = new Player(Color.blue,10,20, handler);
		//tree = new Tree(handler, 0, 10);
		//player2 = new Player(200,200, game);
		

		//game.getGameCamera().move(100,200);
	}


	public void tick(){
		world.tick();
		//player.tick();
		//tree.tick();
		// game.getGameCamera().move(1,1);
		//player2.tick();
	}

	public void render(Graphics g){
		world.render(g);
		//tree.render(g);
		//player.render(g);
		
		//player2.render(g);
		// g.setColor(Color.red);
		// g.fillRect(10,20,40,100); // x,y,width, height
	}

	// Entity: is anything in the game that is NOT a tile(iamge/rectangle), players, items, enemies

	// There is a main Entity class
	// Creater class extends the entity class
	// Player class extends the creater class

	// Every entity needs a position, a tick method, and a render method

	// All the creatures need is health

	// All players need an image and and an input
}