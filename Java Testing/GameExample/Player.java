
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Rectangle;

public class Player extends Creature{

	private Color c;

	private long lastAttackTimer, attackCooldown = 800, attackTimer = attackCooldown;

	public Player(Color c, float x, float y, Handler handler){
		
		super(handler, c, x,y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 3;
		bounds.y = 5;
		bounds.width =10;
		bounds.height = 12;

		this.c = c;
		// This is the constructor
	
	}

	public void tick() {

		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

		checkAttack();
	}

	private void checkAttack(){
		attackTimer += System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer < attackCooldown){
			return;
		}

		Rectangle cb = getCollisionBounds(0,0);
		Rectangle ar = new Rectangle();
		int arSize  = 10;
		ar.width = arSize;
		ar.height = arSize;

		if(handler.getKeyManager().aUp){
			ar.x = cb.x + cb.width/2 - arSize/ 2;
			ar.y = cb.y - arSize;
		}else if(handler.getKeyManager().aDown){
			ar.x = cb.x + cb.width/2 - arSize/ 2;
			ar.y = cb.y + cb.height;
		}else if(handler.getKeyManager().aLeft){
			ar.x = cb.x - arSize;
			ar.y = cb.y + cb.height/2 - arSize/ 2;
		}else if(handler.getKeyManager().aRight){
			System.out.println("YOUR KILLINIG ME");
			ar.x = cb.x + cb.width;
			ar.y = cb.y + cb.height/2 - arSize/ 2;
		}else{
			return;
		}

		attackTimer = 0;

		for(Entity e : handler.getWorld().getEntityManager().getEntities()){
			if(e.equals(this)){
				continue;
			}
			if(e.getCollisionBounds(0,0).intersects(ar)){
				e.hurt(1);
				return;
			}
		}

	}

	public void die(){
		System.out.println("YOU LSOE");
	}

	public void render(Graphics g ){

		g.setColor(c);
		g.fillRect((int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT); // x,y,width, height
		// (int) this is called casting

		g.setColor(Color.blue);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y-handler.getGameCamera().getyOffset()), bounds.width, bounds.height);
	}

	private void getInput(){
		xMove = 0;
		yMove = 0;
		
		if(handler.getKeyManager().up)
			yMove = -speed;
		if(handler.getKeyManager().down)
			yMove = speed;
		if(handler.getKeyManager().left)
			xMove = -speed;
		if(handler.getKeyManager().right)
			xMove = speed;
	}

}