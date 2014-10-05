package thefrog;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class tree {
	private Image image;
	public static final int WIDTH = 120;
	public static final int HEIGHT = 60;
	private int x;
	private int y;
	private int vx;
	
	public float getX() { return x; }
	public float getY() { return y; }
	public float getVx() { return vx; }
	
	public tree(int a,int b, int vx) throws SlickException {
		
		this.x =a;
		this.y =b;
		this.vx = vx;
		image = new Image("res/tree.png");
		
	}
	
	

	public  void render(){
		image.draw(x,Thefrog.GAME_HEIGHT-y);
	}

	public void update() {
	    
	    if(x > 640 - WIDTH){
	    	vx*=-1;
	    	
	    }
	    else if(x<0)
	    	vx*=-1;
	    x-=vx;
	    
	}
	

	
}
