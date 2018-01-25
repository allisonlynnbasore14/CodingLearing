
import java.awt.Color;
import java.awt.image.BufferedImage;

public class RockTile extends Tile{

	public RockTile(int id){
		super(id);
	}

	@Override
	public boolean isSolid(){
		return true;
	}
}