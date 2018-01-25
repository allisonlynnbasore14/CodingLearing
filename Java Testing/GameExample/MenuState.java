
import java.awt.Color;
import java.awt.Graphics;

public class MenuState extends State{

	private UIManager uiManager;

	public MenuState(Handler handler){
		super(handler);
		uiManager = new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);

		uiManager.addObject(new UIImageButton(30,30,30,30, new ClickListener(){

			public void onClick(){
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().gameState);
			}

		}));
	}


	public void tick(){
		uiManager.tick();
	}

	public void render(Graphics g){
		g.setColor(Color.green);
		g.fillRect(10,20,40,100);
		uiManager.render(g); // x,y,width, height
	}

}