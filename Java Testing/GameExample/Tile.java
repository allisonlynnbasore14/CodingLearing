
import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Tile{

	// STATIC STUFF HERE

	public static Tile[] tiles = new Tile[256];
	public static Tile grassTile = new GrassTile(0);
	public static Tile rockTile = new RockTile(1);
	//private Color c = new Color();

	private Color c;
	// THE CLASS

	Random rand = new Random();

	// protected BufferedImage texture;

	public static final int TILEWIDTH = 64, TILEHIEGHT = 64;

	protected final int id;

	public Tile(int id){

		// this.texture = texture;
		this.id = id;

		tiles[id] = this;

	}

	public void tick(){

	}

	public void render(Graphics g, int x, int y, Color c){
		// int  n = rand.nextInt(10) + 1;
		// if(n % 2 == 0){
		// 	c = Color.green;
		// }else{
		// 	c = Color.blue;
		// }
		g.setColor(c);
		g.fillRect( x, y, TILEWIDTH, TILEHIEGHT);

	}

	public boolean isSolid(){
		return false;
	}

	public int getId(){
		return id;
	}
}