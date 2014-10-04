package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class frog {
	
	public float x;
	public  float y;
	private float vjump;
	public  float vy;
	
	
	
	private static Image image;
	public static final int WIDTH = 60;
	public static final int HEIGHT = 60;

	public frog(float x, float y ,float vjump) throws SlickException {
		this.x = x;
		this.y = y;
		this.vy = vjump;
		this.vjump = vjump;
	    
		image = new Image("res/cut.png");
	}
	
	

	public void render() {
		image.draw(x - WIDTH/2, 
				Thefrog.GAME_HEIGHT - y - (HEIGHT/2));
		
	}
	
	public void update() {
		y += vy;
	    vy -= Thefrog.G;
	    if(y < 40 ){
	    	y = 40;
	    }
		
	}
	
	
	public void jump() { 
	    vy = vjump;
	  }	
	
}
