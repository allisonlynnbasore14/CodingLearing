import java.awt.Color;

public abstract class Creature extends Entity{

	public static final int DEFAULT_HEALTH = 100;
	protected float speed;
	protected float xMove, yMove;
	public static final float DEFAULT_SPEED = 3.0f;
	public static final int DEFAULT_CREATURE_WIDTH = 40, DEFAULT_CREATURE_HEIGHT = 40;

	public Creature(Handler handler, Color c, float x, float y, int width, int height){
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public int getHealth(){
		return health;
	}

	public void move(){
		if(!checkEntityCollisions(xMove, 0f))
			moveX();
		if(!checkEntityCollisions(0f, yMove))
			moveY();
	}

	public void moveX(){
		
		if(xMove > 0){
			// Moving right
			int tx = (int) (x + xMove + bounds.x + bounds.width)/ Tile.TILEWIDTH;
			
			if(!collisionWithTile(tx, (int )(y + bounds.y)/Tile.TILEHIEGHT) && !collisionWithTile(tx, (int )(y + bounds.y + bounds.height)/Tile.TILEHIEGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH - bounds.x - bounds.width -1;
			}
		}else if(xMove < 0){
			// Moving left
			int tx = (int) (x + xMove + bounds.x)/ Tile.TILEWIDTH;
			if(!collisionWithTile(tx, (int )(y + bounds.y)/Tile.TILEHIEGHT) && !collisionWithTile(tx, (int )(y + bounds.y + bounds.height)/Tile.TILEHIEGHT)){
				x += xMove;
			}else{
				x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
			}
		}	
	}

	public void moveY(){
		if(yMove < 0){//Up
			int ty = (int) (y + yMove + bounds.y) / Tile.TILEHIEGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHIEGHT + Tile.TILEHIEGHT - bounds.y;
			}
		}else if(yMove > 0){//Down
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHIEGHT;
			
			if(!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
					!collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty)){
				y += yMove;
			}else{
				y = ty * Tile.TILEHIEGHT - bounds.y - bounds.height -1;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y){
		return handler.getWorld().getTile(x,y).isSolid();
	}


	public float getSpeed(){
		return speed;
	}

	public void setSpeed(float speed){
		this.speed = speed;
	}


	public float getxMove() {
		return xMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void die(){
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}


}