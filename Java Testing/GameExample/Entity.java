
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

	// Entity: is anything in the game that is NOT a tile(iamge/rectangle), players, items, enemies

	// There is a main Entity class
	// Creater class extends the entity class
	// Player class extends the creater class

	// Every entity needs a position, a tick method, and a render method

	// All the creatures need is health

	// All players need an image and and an input


public abstract class Entity{

	protected int health;
	protected Handler handler;
	protected float x,y;
	protected int width, height;
	protected Rectangle bounds;
	public static final int DEFAULT_HEALTH = 10;
	protected boolean active = true;


	// a private variable but can still be used by children classes

	public Entity(Handler handler, float x, float y, int width, int heigh){
		this.handler = handler;
		this.x = x;
		this.y = y;		
		this.width = width;
		this.height = height;

		health = DEFAULT_HEALTH;

		bounds = new Rectangle(0,0,width, height);
	}

	public abstract void tick();

	public boolean checkEntityCollisions(float xOffset, float yOffset){
		for(Entity e: handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this))
				continue;
			if(e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset))){
		
				return true;
			}
			
		}
		return false;
	}


	public abstract void die();


	public void hurt(int amt){
		health -= amt;
		if(health <= 0){
			active = false;
			die();
		}
	}


	public void setHealth(int h){
		this.health = h;
	}

	public int getHealth(){
		return health;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public Rectangle getCollisionBounds(float xOffset, float yOffset){
		return new Rectangle((int) (x+ bounds.x + xOffset), (int) (y+ bounds.y + yOffset), bounds.width, bounds.height);
	}

	public float getX(){
		return x;
	}

	public void setX(float x){
		this.x = x;
	}

	public float getY(){
		return y;
	}

	public void setY(float y){
		this.y = y;
	}

	public int getWidth(){
		return width;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getHeight(){
		return height;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public abstract void render(Graphics g);

}