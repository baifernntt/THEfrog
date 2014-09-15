package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class frog {
	
	float x;
	float y;
	
	
	private static Image image;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;

	public frog(float x, float y ,float vjump) throws SlickException {
		this.x = x;
		this.y = y;
		
	    
		image = new Image("res/cut.png");
	}
	
	

	public void render() {
		image.draw(x - WIDTH/2, 
				Thefrog.GAME_HEIGHT - y - (HEIGHT/2));
		
	}
	
	
}
