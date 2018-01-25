import java.awt.Graphics;
import java.awt.Color;

public class Tree extends StaticEntity {
	public Tree(Handler hander, float x, float y){
		super(hander, x, y, Tile.TILEWIDTH, Tile.TILEHIEGHT * 2);
	}

	public void tick(){

	}

	public void render(Graphics g){
		g.setColor(Color.red);
		g.fillRect( (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()),10,20);
	}

	public void die(){
		System.out.println("YOU LSOE");
	}

}