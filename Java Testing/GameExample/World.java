
import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math;

public class World {

	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;
	private Handler handler;
	private Color c;
	private EntityManager entityManager;

	// Entities
	private EntityManager entitiesManager;
	
	public World(Handler handler, String path){
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Player(Color.cyan, 100,100, handler));
		entityManager.addEntity(new Tree(handler, 20,100));
		entityManager.addEntity(new Tree(handler, 20,50));
		entityManager.addEntity(new Tree(handler, 20,80));
		loadWorld(path);

		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	
	public void tick(){
		entityManager.tick();

		
	}
	
	public void render(Graphics g){

		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH );
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHIEGHT );;
		int xEnd = (int) Math.min(width, (handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yEnd = (int) Math.min(height, (handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHIEGHT + 1);
		for(int y = yStart;y < yEnd;y++){
			for(int x = xStart;x < xEnd ;x++){
				c = getColor(getTile(x,y));
 				getTile(x,y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()), (int ) (y * Tile.TILEHIEGHT - handler.getGameCamera().getyOffset()), c);//*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);
			}
		}
		entityManager.render(g);
	}
	
	public Tile getTile(int x, int y){

		if(x < 0 || y < 0 || x >= width || y >= height){
			return Tile.grassTile;
		}

		Tile t = Tile.tiles[tiles[x][y]];
		if(t == null){
			return Tile.tiles[tiles[0][0]];
		}
		return t;

	}

	public Color getColor( Tile t){
		if(t.getId() == 0){
			return Color.green;
		}else{
			return Color.gray;
		}
	}
	
	private void loadWorld(String path){
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		tiles = new int[width][height];
		for(int y = 0;y < height;y++){
			for(int x = 0;x < width;x++){
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}
	}

	public int getWidth(){
		return width;

	}
	public int getHeight(){
		return height;
		
	}
	

	public EntityManager getEntityManager(){
		return entityManager;
	}
}


// public class World{

// 	private int width, height; //IN units of tiles
// 	private int spawnX, spawnY;
// 	private int[][] tiles; // makes a multidimensional array

// 	public World(String path){
// 		loadWorld(path);

// 	}

// 	// private void loadWorld(String path){
// 	// 	width = 5;
// 	// 	height = 5;
// 	// 	tiles = new int[width][height];

// 	// 	// for now it is all set to index 0

// 	// 	for (int x = 0; x< width; x++){
// 	// 		for(int y = 0; y< height; y++){
// 	// 			tiles[x][y]=0;
// 	// 		}
// 	// 	}
// 	// }



// 	public void tick(){

// 	}

// 	public void render(Graphics g){
// 		for(int y = 0; y< height;y++){
// 			for(int x = 0; x< width; x++){
// 				getTile(x,y).render(g, x * Tile.TILEWIDTH, y * Tile.TILEHIEGHT);//*Tile.TILEWIDTH,y*Tile.TILEHEIGHT);

// 			}
// 		}
// 	}

// 	public Tile getTile(int x, int y){
// 		Tile t = Tile.tiles[tiles[x][y]];
// 		if(t == null){
// 			return Tile.tiles[tiles[0][0]];
// 		}
// 		return t;
// 	}

// 	private void loadWorld(String path){
// 		String file = Utils.loadFileAsString(path);
// 		String[] tokens = file.split("\\s+");
// 		width = Utils.parseInt(tokens[0]);
// 		height = Utils.parseInt(tokens[1]);
// 		spawnX = Utils.parseInt(tokens[2]);
// 		spawnY = Utils.parseInt(tokens[2]);


// 		tiles = new int[width][height];
// 		for(int y = 0; y<height; y++){
// 			for(int x = 0; y< width; x++){
// 				tiles[x][y] = Utils.parseInt(tokens[(x + y * width)+4]);
// 			}
// 		}
// 	}





// }
