import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;

public class EntityManager {


	private Handler handler;
	private Player player;
	private ArrayList<Entity> entities;
	// Sorting this array will lets up determine which entities are rendered first


	private Comparator<Entity> renderSorter = new Comparator<Entity>(){
		public int compare(Entity a, Entity b){
			if(a.getY() + a.getHeight() < b.getY() + b.getHeight()){
				return -1;
			}else{
				return 1;
			}
		}
	};
	// Allows us to add any remove as many as we want to


	public EntityManager(Handler handler, Player player){
		this.handler = handler;
		this.player = player;
		entities = new ArrayList<Entity>();
		addEntity(player);

	}

	public void tick(){
		for(int i = 0; i < entities.size(); i++){
			Entity e = entities.get(i);
			e.tick();
			if(!e.isActive())
				entities.remove(e);
		}
		entities.sort(renderSorter);
	}

	public void render(Graphics g){
		for(Entity e : entities){
			e.render(g);
		}
	}


	public void addEntity(Entity e){
		entities.add(e);
	}

	public ArrayList<Entity> getEntities() {
		return entities;
	}

	public Handler getHandler(){
		return handler;
	}

	public Player getPlayer(){
		return player;
	}

	public void getHandler(Handler handler){
		
	}





}